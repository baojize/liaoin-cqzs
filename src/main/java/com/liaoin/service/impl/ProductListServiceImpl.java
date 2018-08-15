package com.liaoin.service.impl;

import com.liaoin.entity.ProductList;
import com.liaoin.mapper.ProductListMapper;
import com.liaoin.service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 15:32 2018/8/6
 * @Description:
 */
@Service
@Transactional
public class ProductListServiceImpl implements ProductListService {
    @Autowired
    private ProductListMapper productListMapper;


    @Override
    public int insert(ProductList record) {
        return productListMapper.insert(record);
    }

    @Override
    public int insertSelective(ProductList record) {
        return productListMapper.insertSelective(record);
    }

    @Override
    public int insertProductList(String productlistName,Double productlistPrice) {
        return productListMapper.insertProductList(productlistName,productlistPrice);
    }

    @Override
    public int updateByPrimaryKey(ProductList record) {
        return productListMapper.updateByPrimaryKey(record);
    }

    @Override
    public ProductList selectByPrimaryKey(Integer productlistId) {
        return productListMapper.selectByPrimaryKey(productlistId);
    }

    @Override
    public ProductList selectHotProductList(Integer productlistId) {
        return productListMapper.selectHotProductList(productlistId);
    }

    @Override
    public int deleteByPrimaryKey(Integer productlistId) {
        return productListMapper.deleteByPrimaryKey(productlistId);
    }

}
