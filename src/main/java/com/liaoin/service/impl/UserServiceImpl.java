package com.liaoin.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.liaoin.common.AliyunSmsUtils;
import com.liaoin.common.PageBean;
import com.liaoin.common.Result;
import com.liaoin.entity.SystemAliyunSms;
import com.liaoin.entity.SystemSmsTemplate;
import com.liaoin.entity.User;
import com.liaoin.mapper.UserMapper;
import com.liaoin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 9:25 2018/7/27
 * @Description:
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     */
    @Override
    public void userRegister(String userMobile, String userName, String userPassword) throws UnsupportedEncodingException {
        userMapper.userRegister(userMobile,userName,userPassword);
    }
    /**
     * 用户登录
     */
    @Override
    public void userLogin(String userMobile, String userPassword) {
       userMapper.userLogin(userMobile,userPassword);
    }
    /**
     * 通过id查询用户
     */
    @Override
    public User userById(Integer userId) {
        return userMapper.userById(userId);
    }
    /**
     * 通过id删除用户
     */
    @Override
    public Integer userDelete(Integer userId) {
         return userMapper.userDelete(userId);
    }

    /**
     * 通过id修改用户
     */
    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
    /**
     * 查詢所有用戶分頁
     */
    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }
    /**
     *  阿里云发送短信
     */
    @Override
    public void sendSms(String userMobile, String code, SystemAliyunSms systemAliyunSms) throws ClientException {
        // 1.发送短信，获取验证码的模板编号
        String templateCode = null;
        for (SystemSmsTemplate systemSmsTemplate : systemAliyunSms.getSystemSmsTemplateList()) {
            String templateName = systemSmsTemplate.getTemplateName();
            if ("验证码".equals(templateName)) {
                templateCode = systemSmsTemplate.getTemplateCode();
                break;
            }
        }
        String templateParam = "{\"code\":\"" + code + "\"}";
        AliyunSmsUtils.sendSms(systemAliyunSms.getAccessKeyId(), systemAliyunSms.getAccessKeySecret(), systemAliyunSms.getSignName(), userMobile, templateCode, templateParam);
        userMapper.sendSms(userMobile,code,systemAliyunSms);
    }
    /**
     * 校验验证码
     */
    @Override
    public Result checkCode(String userMobile, String code) {
        if (code == null){
            return new Result(300,"验证码错诶",null);
        }
        return new Result(200,"验证成功",null);
    }
    //查询用户购买的商品信息
    @Override
    public List<User> findUserAndProductList(Integer userId) throws Exception {
        return userMapper.findUserAndProductList(userId);
    }

    /**
     *  查询用户电话
     */
    @Override
    public  User findByUserMobile(String userMobile) {
        return userMapper.findByUserMobile(userMobile);
    }
    /**
     *  查询用户昵称
     */
    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
    /**
     *  查询用户密码
     */
    @Override
    public  User findByUserPassword(String userPassword) {
        return userMapper.findByUserPassword(userPassword);
    }
    /**
     *  用户分页
     */
    @Override
    public PageBean<User> pageQuery(Pageable pageable, User user) {
        return userMapper.pageQuery(pageable,user);
    }
}