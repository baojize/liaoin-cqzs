package com.liaoin.service.impl;

import com.liaoin.entity.Product;
import com.liaoin.entity.ProductExample;
import com.liaoin.entity.ProductList;
import com.liaoin.mapper.ProductMapper;
import com.liaoin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 10:14 2018/7/25
 * @Description:
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    /**
     *  查询商品类目下所有商品信息
     */
    @Override
    public void insert(String productnName) {
        productMapper.insert(productnName);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer productId) {
        return productMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public Product selectByPrimaryKey(Integer productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<Product> selectByExample(ProductExample example) {
        return productMapper.selectByExample(example);
    }

    @Override
    public List<Product> selectProduct() {
        return productMapper.selectProduct();
    }

    @Override
    public List<Product> getProductById(Integer productId) {
        return productMapper.getProductById(productId);
    }


}
