package com.liaoin.mapper;

import com.liaoin.entity.ProductList;
import com.liaoin.entity.ProductListExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductListMapper {

    long countByExample(ProductListExample example);

    int deleteByExample(ProductListExample example);

    int deleteByPrimaryKey(Integer productlistId);

    int insert(ProductList record);

    int insertSelective(@Param(value = "record") ProductList record);

    int insertProductList(@Param("productlistName") String productlistName,@Param("productlistPrice") Double productlistPrice);

    List<ProductList> selectByExample(ProductListExample example);

    ProductList selectByPrimaryKey(Integer productlistId);

    ProductList selectHotProductList(Integer productlistId);

    int updateByExampleSelective(@Param("record") ProductList record, @Param("example") ProductListExample example);

    int updateByExample(@Param("record") ProductList record, @Param("example") ProductListExample example);

    int updateByPrimaryKeySelective(ProductList record);

    int updateByPrimaryKey(ProductList record);
}