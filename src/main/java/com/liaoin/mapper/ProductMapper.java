package com.liaoin.mapper;

import com.liaoin.entity.Product;
import com.liaoin.entity.ProductExample;
import com.liaoin.entity.ProductList;
import com.liaoin.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 9:58 2018/7/25
 * @Description:分类模块
 */
public interface ProductMapper {
    /**
     *  查询商品类目下所有商品信息
     */

    List<Product> selectProduct();

    void   insert(String productName);

    int insertSelective(Product record);

    int deleteByPrimaryKey(Integer productId);

    int updateByPrimaryKey(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer productId);

    List<Product> getProductById(Integer productId);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);



}
