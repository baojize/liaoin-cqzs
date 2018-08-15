package com.liaoin.service;

import com.liaoin.entity.ProductList;

/**
 * @Author: ldw
 * @Date: created in 15:32 2018/8/6
 * @Description:
 */
public interface ProductListService {

    int insert(ProductList record);

    int insertSelective(ProductList record);

    int insertProductList(String productlistName,Double productlistPrice);

    int updateByPrimaryKey(ProductList record);

    ProductList selectByPrimaryKey(Integer productlistId);

    ProductList selectHotProductList(Integer productlistId);

    int deleteByPrimaryKey(Integer productlistId);

}
