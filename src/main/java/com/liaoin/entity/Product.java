package com.liaoin.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 17:39 2018/7/24
 * @Description:
 */
@Data
public class Product {
    private Integer productId;
    private String productName;
    //商品类目和商品详情一对多关系
    private List<ProductList> productLists;

    private Product product;



}
