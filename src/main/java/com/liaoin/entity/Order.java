package com.liaoin.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
public class Order {
    private String id;

    private String note;

    private BigDecimal num;

    private Integer userId;

    private BigDecimal money;

    private Date creattime;

    private BigDecimal amount;

    private Integer orderId;

    private String status;//1、未付款，2、未发货，3、待收货，4、已完成

    private User user;

    private List<OrderOption> orderOptionList = new ArrayList<>();

}