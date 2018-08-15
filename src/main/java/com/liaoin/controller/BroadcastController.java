package com.liaoin.controller;

import com.liaoin.common.Result;
import com.liaoin.entity.Broadcast;
import com.liaoin.service.BroadcastService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author: ldw
 * @Date: created in 15:21 2018/8/10
 * @Description:
 */
@RestController
@Api(value = "轮播图模块",description = "BroadcastController",tags = "轮播图模块")
public class BroadcastController {
    @Autowired
    private BroadcastService broadcastService;

    @Autowired
    private ServletContext servletContext;

    @GetMapping("getBroadcast")
    @ApiOperation("获取轮播图")
    public Result getBroadcast(@RequestParam Integer size) {
        List<Broadcast> broadcast = broadcastService.getBroadcast(size);
        return new Result(200, "查询成功", broadcast);
    }

    @GetMapping("selectByBroadcastKey")
    @ApiOperation("查询轮播图")
    public Result selectByBroadcastKey(@RequestParam Integer id) {
        if (id == null) {
            return new Result(300, "此轮播图不存在", null);
        }
        Broadcast broadcast = broadcastService.selectByPrimaryKey(id);
        return new Result(200, "查询成功", broadcast);
    }

    @PostMapping("deleteByBroadcastKey")
    @ApiOperation("删除轮播图")
    public Result deleteByBroadcastKey(@RequestParam Integer id) {
        if (id == null) {
            return new Result(300, "此轮播图不存在", null);
        }
        int i = broadcastService.deleteByPrimaryKey(id);
        return new Result(200, "删除成功", i);
    }

    @PostMapping("updateBroadcast")
    @ApiOperation("修改轮播图")
    public Result updateBroadcast(@RequestBody Broadcast record) {
        if (record == null) {
            return new Result(300, "此轮播不存在", null);
        }
        int i = broadcastService.updateByPrimaryKey(record);
        return new Result(200, "修改成功", i);
    }

    @PostMapping("uploadBroadcast")
    @ApiOperation("上传轮播图")
    @ApiImplicitParam(name = "id",value = "图片编号", dataType = "String", paramType = "query", required = true)
    public Result uploadBroadcast(@ApiParam(value = "上传文件", required = true) MultipartFile multipartFile, @RequestParam Integer id, HttpServletRequest request) throws IOException {
        //判断图片id是否存在
        Broadcast broadcastid = broadcastService.selectByPrimaryKey(id);
        if (broadcastid == null) {
            return new Result(300,"图片id不存在",null);
        }
        //上传文件
        String originalFilename = multipartFile.getOriginalFilename();
        String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        //创建上传文件夹
        String realPath = servletContext.getRealPath("/uploadBroadcast/");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String format = simpleDateFormat.format(new Date());

        File dir = new File("D://uploadBroadcast");
        File dateFile = new File(dir.toString()+"//"+format);
        if (!dateFile.exists()) {
            boolean mkdirs = dateFile.mkdirs();
            System.out.println("创建上传文件夹");
        }
        //上传文件
        File file = new File(dateFile, filename);
        FileCopyUtils.copy(multipartFile.getBytes(),file);
        Broadcast broadcast= new Broadcast();
        broadcast.setContent(originalFilename);
        broadcast.setUrl("/uploadBroadcast/"+ format +"/"+filename);
        broadcast.setCreateTime(new Date());
        broadcast.setUpdateTime(new Date());
        broadcastService.insert(broadcast);
        System.out.println("新增文件信息");
        //更新信息
        broadcastService.updateByPrimaryKey(broadcast);
        return new Result(200,"上传成功",broadcast);
    }
}