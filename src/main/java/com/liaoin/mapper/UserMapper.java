package com.liaoin.mapper;

import com.aliyuncs.exceptions.ClientException;
import com.liaoin.common.PageBean;
import com.liaoin.entity.SystemAliyunSms;
import com.liaoin.entity.User;
import com.liaoin.entity.UserExample;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * @Author: ldw
 * @Date: created in 17:36 2018/7/26
 * @Description:
 */
public interface UserMapper {
    /**
     * 用户注册
     */
    @Insert("insert into `user`(user_mobile,user_name,user_password) values(#{userMobile},#{userName},#{userPassword})")
    void userRegister(@Param("userMobile") String userMobile, @Param("userName") String userName, @Param("userPassword") String userPassword);
    /**
     *  用户登录
     */
    @Select("select user_mobile,user_password from `user`")
    @Results({
            @Result(property = "userMobile", column = "user_mobile"),
            @Result(property = "userPassword", column = "user_password"),
    })
    void userLogin(String userMobile,String userPassword);

    /**
     *  通过id查询用户
     */
    @Select("select user_mobile, user_name,user_password from user where user_id = #{userId}")
    @Results({
            @Result(property ="userMobile",column = "user_mobile"),
            @Result(property ="userName",column = "user_name"),
            @Result(property ="userPassword",column = "user_password")
    })
    User userById(Integer userId);

    /**
     *  通过id删除用户
     */
    @Delete("DELETE FROM user WHERE user_id =#{userId}")
    Integer userDelete(Integer userId);
    /**
     *  通过id修改用户
     */
    @Update("UPDATE user SET user_name = #{userName},user_password = #{userPassword} WHERE user_id = #{userId}")
    void updateUser(User user);

    /**
     *  分页查询用户
     */
    @Select("SELECT * FROM `user`")
    List<User> listUser();

    /**
     * 条件分页查询
     */
    @Select("SELECT  user_name FROM `user`where user_name = #{userName}")
    PageBean<User> pageQuery(Pageable pageable, User user);

    /**
     * 查询用户电话
     * @param user
     */
    @Select("select user_mobile from user where user_mobile = #{userMobile}")
    @Results({
            @Result(property = "userMobile", column = "user_mobile"),
    })
    User findByUserMobile(String userMobile);
    /**
     *  查询用户昵称
     */
    @Select("select user_name from user where user_name = #{userName}")
    @Results({
            @Result(property ="userName",column = "user_name"),
    })
    User findByUserName(String userName);
    /**
     *  查询用户密码
     */
    @Select("select user_password from user where user_password = #{userPassword}")
    @Results({
            @Result(property ="userPassword",column = "user_password"),
    })
    User findByUserPassword(String userPassword);

    /**
     *  阿里云发送短信
     */
    void sendSms(String userMobile, String code, SystemAliyunSms systemAliyunSms) throws ClientException;
    /**
     *  校验验证码
     */
    Result checkCode(String userMobile, String code);



    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //查询用户购买的商品信息
     List<User> findUserAndProductList(Integer userId)throws Exception;


}
