package com.liaoin.entity;

import lombok.Data;

/**
 * @Author: ldw
 * @Date: created in 15:47 2018/7/26
 * @Description:收货地址实体类
 */
@Data
public class Address {
    private Integer Addressid;
    //收货人姓名
    private String AddressName;
    //收货人电话
    private String AddressMobile;
    //收货人地址
    private String Address;
    //用户
    private User user;
    //是否删除
    private String isDelete;
}
