package com.liaoin.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ldw
 * @Date: created in 9:14 2018/7/25
 * @Description:
 */
@Data
public class ProductList {
    private Integer productListId;
    //商品名称
    private String productListName;
    //商品价格
    private Double productListPrice;
    //商品介绍
    private String productListDetails;
    //商品库存
    private String productListRep;
    //商品图片
    private String productListPicture;
    //热门商品
    private String productListHot;
    //商品类目id
    private Integer productId;
    //商品类目
    private Product product;
    //图片列表
    private Set<Image> imageList = new HashSet<>();

}
