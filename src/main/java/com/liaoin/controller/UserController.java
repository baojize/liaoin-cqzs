package com.liaoin.controller;

import com.aliyuncs.exceptions.ClientException;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liaoin.common.MobileUtils;
import com.liaoin.common.Result;
import com.liaoin.entity.Image;
import com.liaoin.entity.SystemAliyunSms;
import com.liaoin.entity.User;
import com.liaoin.service.ImageService;
import com.liaoin.service.UserService;
import io.swagger.annotations.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @Author: ldw
 * @Date: created in 17:43 2018/7/26
 * @Description:
 */
@RestController
@Api(value = "用户模块",description = "UserController",tags = "用户模块")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    private ImageService imageService;

    /**
     *  阿里云发送短信
     */
    @ApiOperation("获取验证码，app端请设置获取验证码60秒CD")
    @RequestMapping(value = "/getCode",method = RequestMethod.GET)
    public Result getCode(@RequestParam String userMobile) throws ClientException {
        //1.验证手机号
        if (!MobileUtils.isMobileNumber(userMobile)) {
            return new Result(300,"请输入正确的手机号码",null);
        }
        //2.生成短信验证码
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        // 3.获取阿里云短信系统参数
        Object systemAliyunSms = servletContext.getAttribute("systemAliyunSms");
        SystemAliyunSms systemAliyunSms1 = (SystemAliyunSms) systemAliyunSms;
        // 3.将短信验证码放入redis中，并发送短信
        /*userService.sendSms(userMobile,code+ "",systemAliyunSms1);*/
        return new Result(200,"短信已发送",code);
    }

    /**
     * 校验验证码
     */
    @ApiOperation("校验验证码")
    @RequestMapping(value = "/checkCode", method = RequestMethod.GET)
    public Result checkCode(@RequestParam String userMobile, @RequestParam String code) throws ClientException {
        // 1.校验手机号是否合法
        boolean mobileNumber = MobileUtils.isMobileNumber(userMobile);
        if (!mobileNumber){
            return new Result(300,"请输入正确手机号码",null);
        }
        //2.验证手机号码是否已经注册
        User byUserMobile = userService.findByUserMobile(userMobile);
        if (byUserMobile != null){
            return new Result(300,"手机已经注册",null);
        }
        // 3.校验验证码
        return userService.checkCode(userMobile,code);
    }

    /**
     *  用户注册
     */
    @ApiOperation(value = "注册", notes = "注册")
    @RequestMapping(value = "/userRegister",method = RequestMethod.POST)
    public Result userRegister(@RequestParam String userMobile,@RequestParam String userName, @RequestParam String userPassword) throws UnsupportedEncodingException {
        // 1.验证手机号是否存在
        boolean mobileNumber = MobileUtils.isMobileNumber(userMobile);
        if (!mobileNumber){
            return new Result(300, "请输入正确的手机号码", null);
        }
        // 2.校验手机号是否已经注册
        User byUserMobile = userService.findByUserMobile(userMobile);
        if (byUserMobile != null) {
            return new Result(300,"手机已经注册",null);
        }
        // 3.校验昵称是否已经存在
        User byUserName = userService.findByUserName(userName);
        if (byUserName != null) {
            return new Result(300, "昵称已经存在", null);
        }
        //4 .校验密码是否已经存在
        User byUserPassword = userService.findByUserPassword(userPassword);
        if (byUserPassword != null) {
            return new Result(300, "密码已存在", null);
        }
        // 5.新增注册用户
        userService.userRegister(userMobile,userName,userPassword);
       return new Result(200,"注册成功",userName);
    }
    /**
     *  上传头像图片
     */
    @ApiOperation("上传头像图片")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ApiImplicitParam(name = "userId", value = "用户编号", dataType = "String", paramType = "query", required = true)
    public Result upload(@ApiParam(value = "上传的文件，此接口只能上传一个文件", required = true) MultipartFile multipartFile, @RequestParam Integer userId, HttpServletRequest request) throws IOException {
        // 1.判断用户是否存在
        User user = userService.userById(userId);
        if (user == null){
            return new Result(300,"此用户不存在",null);
        }
        //2.上传文件
        //2.1获取文件名
        String originalFilename = multipartFile.getOriginalFilename();
        String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        //2.2创建上传文件夹
        String realPath = servletContext.getRealPath("/upload/");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String datePath = simpleDateFormat.format(new Date());

        File dir = new File("D://upload");
        File dateFile = new File(dir.toString() + "//" + datePath);
        if (!dateFile.exists()){
            boolean mkdirs = dateFile.mkdirs();
            System.out.println("创建上传文件夹");
        }
        //2.3上传文件
        File file = new File(dateFile, filename);
        FileCopyUtils.copy(multipartFile.getBytes(),file);
        //2.4新增文件信息
        Image image = new Image();
        image.setContent(originalFilename);
        image.setType("1");
        image.setUrl("/upload/" + datePath + "/" + filename);
        imageService.insert(image);
        System.out.println("新增文件信息");
        //3.更新用户信息
        user.setImage(image);
        userService.updateUser(user);
        System.out.println("修改用户信息");
        return new Result(200,"上传成功",user);
    }


    /**
     *  用户登录
     */
    @ApiOperation(value = "登录", notes = "登录")
    @RequestMapping(value = "/userLogin",method = RequestMethod.POST)
    public Result userLogin(@RequestParam String userMobile,@RequestParam String userPassword, HttpSession session) {
        // 1.检验是否是手机号码
        boolean mobileNumber = MobileUtils.isMobileNumber(userMobile);
        if (!mobileNumber){
            return new Result(300,"请输入正确的手机号码",null);
        }
        // 2.验证手机号码是否注册
        User byUserMobile = userService.findByUserMobile(userMobile);
        if (byUserMobile == null) {
            return new Result(300, "该手机号码尚未注册", null);
        }
        // 3.验证密码是否存在
        User byUserPassword = userService.findByUserPassword(userPassword);
        if (byUserPassword == null) {
            return new Result(300,"密码错误",null);
        }
        // 3.将用户信息放入session
        session.setAttribute("loginUser",byUserMobile);
      /*  session.setAttribute("loginPassword",byUserPassword);*/
        return new Result(200,"登录成功",byUserMobile);
    }

    /**
     * 获取当前登录 用户
     */
    @ApiOperation(value = "当前登录用户", notes = "当前登录用户")
    @RequestMapping(value = "/getLoginUser", method = RequestMethod.POST)
    public Result getLoginUser(HttpSession session) {
        // 1.用户是否登录
        User loginUser = (User) session.getAttribute("loginUser");
        /*User loginPassword = (User) session.getAttribute("loginPassword");*/
        if (loginUser == null){
            return new Result(300,"请先登录",null);
        }
        //获取用户信息
        loginUser = userService.userById(loginUser.getUserId());
       /* userService.findByUserPassword(loginPassword.getUserPassword());*/
        return new Result(200, "获取成功", loginUser);
    }

    /**
     *  通过id查询用户
     */
    @ApiOperation(value = "id查询用户", notes = "id查询用户")
    @RequestMapping(value = "/userById",method = RequestMethod.GET)
    public Result userById(@RequestParam Integer userId) {
        User user = userService.userById(userId);
        if (user == null) {
            return new Result(300,"没有此用户",null);
        }
        return new Result(200,"查询成功",user);
    }
    /**
     *  通过id删除用户
     */
    @ApiOperation(value = "id删除用户", notes = "id删除用户")
    @RequestMapping(value = "/userDelete",method = RequestMethod.POST)
    public Result userDelete(@RequestBody Integer userId) {
        Integer user = userService.userDelete(userId);
        if (user == null){
            return new Result(300,"没有此用户",null);
        }
        return new Result(200,"删除成功",userId);

    }

    /**
     * 通过id修改用户
     */
    @ApiOperation(value = "id修改用户", notes = "id修改用户")
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public Result updateUser(@RequestBody User user) throws UnsupportedEncodingException {
        if (!Objects.isNull(user.getUserPassword())){
            user.setUserPassword(DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes("UTF-8")));
        }
        userService.updateUser(user);
        return new Result(200, "修改成功", user);
    }
    /**
     * 查詢所有用戶分頁
     */
    @ApiOperation(value = "用户分页", notes = "用户分页")
    @RequestMapping(value = "/userGet", method = RequestMethod.POST)
    public Page userGet(@RequestParam Integer page, @RequestParam Integer size) {
          //分页并查询
        Page<User> pageInfo = PageHelper.startPage(page, size);
        List<User> users = userService.listUser();
        //获取分页信息演示
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        List<User> result = pageInfo.getResult();//和上面的users结果相同
        return pageInfo;
    }
    //查询用户购买的商品信息

    @ApiOperation("查询用户购买的商品")
    @RequestMapping(value = "/findUserAndProductList", method = RequestMethod.GET)
    public Result findUserAndProductList(@RequestParam Integer userId) throws Exception {
         userService.findUserAndProductList(userId);
        return new Result(200,"查询成功",userId);
    }
}
