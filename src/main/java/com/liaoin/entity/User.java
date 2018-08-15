package com.liaoin.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 15:25 2018/7/26
 * @Description:
 */
@Data
public class User {
    private Integer userId;
    private String userMobile;
    private String userPassword;
    private String userName;
    // 用户头像
    private Image image;
    // 用户创建的订单列表
    private List<Order> orderList;


}
