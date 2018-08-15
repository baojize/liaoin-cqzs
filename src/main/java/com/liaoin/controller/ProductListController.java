package com.liaoin.controller;

import com.liaoin.common.Result;
import com.liaoin.entity.Product;
import com.liaoin.entity.ProductList;
import com.liaoin.service.ProductListService;
import com.liaoin.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 15:34 2018/8/6
 * @Description:
 */
@RestController
@Api(value = "商品模块",description = "ProductListController",tags = "商品模块")
public class ProductListController {
    @Autowired
    private ProductListService productListService;

    @ApiOperation("id查询商品")
    @GetMapping("selectByPrimaryKey")
    public Result selectByPrimaryKey(@RequestParam Integer productlistId) {
        ProductList productList = productListService.selectByPrimaryKey(productlistId);
        return new Result(200, "查询成功", productList);
    }

    @ApiOperation("查询热门商品")
    @GetMapping("selectHotProductList")
    public Result selectHotProductList(@RequestParam Integer productlistId) {
        ProductList productList = productListService.selectHotProductList(productlistId);
        return new Result(200, "查询成功", productList);
    }

    @ApiOperation("删除商品")
    @PostMapping("deleteByPrimaryKey")
    public Result deleteByPrimaryKey(@RequestParam Integer productlistId) {
        productListService.deleteByPrimaryKey(productlistId);
        return new Result(200, "删除成功", productlistId);
    }

    @ApiOperation("新增商品")
    @PostMapping("insertProductList")
    public Result insertProductList(@RequestParam String productlistName, @RequestParam Double productlistPrice) {
        int i = productListService.insertProductList(productlistName, productlistPrice);
        return new Result(200, "新增成功", i);
    }
}
