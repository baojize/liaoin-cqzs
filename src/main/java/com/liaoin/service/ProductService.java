package com.liaoin.service;

import com.liaoin.entity.Product;
import com.liaoin.entity.ProductExample;
import com.liaoin.entity.ProductList;

import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 10:13 2018/7/25
 * @Description:
 */
public interface ProductService {


    void insert(String productName);

    int updateByPrimaryKey(Product record);

    int deleteByPrimaryKey(Integer productId);

    Product selectByPrimaryKey(Integer productId);

    List<Product> selectByExample(ProductExample example);

    List<Product> selectProduct();

    List<Product> getProductById(Integer productId);

}