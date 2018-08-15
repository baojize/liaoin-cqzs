package com.liaoin.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderOption {
    private Integer id;

    private Integer num;

    private Integer productlistId;

    private Integer orderId;

    private BigDecimal money;

    private Order order;

    //商品信息
    private ProductList productLists;
}