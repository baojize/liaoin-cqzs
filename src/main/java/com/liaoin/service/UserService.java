package com.liaoin.service;

import com.aliyuncs.exceptions.ClientException;
import com.liaoin.common.PageBean;
import com.liaoin.common.Result;
import com.liaoin.entity.SystemAliyunSms;
import com.liaoin.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import java.io.UnsupportedEncodingException;
import java.util.List;


/**
 * @Author: ldw
 * @Date: created in 17:39 2018/7/26
 * @Description:
 */
public interface UserService {
    /**
     *  用户注册
     */
    void userRegister(String userMobile, String userName, String userPassword) throws UnsupportedEncodingException;

    /**
     *  用户登录
     */
    void userLogin(String userMobile,String userPassword);

    /**
     * 查询用户电话
     */
    User findByUserMobile(String userMobile);

    /**
     * 查询用户昵称
     */
    User findByUserName(String userName);
    /**
     *  查询用户密码
     */
    User findByUserPassword(String userPassword);

    /**
     * 条件分页查询
     */
    PageBean<User> pageQuery(Pageable pageable, User user);


    /**
     * 通过id查询用户
     */
    User userById(Integer userId);

    /**
     *  通过id删除用户
     */
    Integer userDelete(Integer userId);
    /**
     *  通过id修改用户
     */
    void updateUser(User user);

    /**
     *  分页查询用户
     */
    @Select("SELECT * FROM `user`")
    List<User> listUser();

    /**
     *  阿里云发送短信
     */
    void sendSms(String mobile, String code, SystemAliyunSms systemAliyunSms) throws ClientException;
    /**
     * 校验验证码
     */
    Result checkCode(String userMobile, String code);

    //查询用户购买的商品信息
    List<User> findUserAndProductList(Integer userId)throws Exception;

}
