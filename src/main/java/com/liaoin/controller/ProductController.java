package com.liaoin.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liaoin.common.Result;
import com.liaoin.entity.Product;
import com.liaoin.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author: ldw
 * @Date: created in 10:18 2018/7/25
 * @Description:
 */
@RestController
@Api(value = "分类模块",description = "Product",tags = "分类模块")
public class ProductController {
    @Autowired
    private ProductService productService;


    @ApiOperation(value = "分类列表分页", notes = "分类列表分页")
    @RequestMapping(value = "/selectProduct",method = RequestMethod.GET)
    public List<Product> selectProduct(@RequestParam Integer page, @RequestParam Integer size ) {
        //分页并查询
        Page<Product> pageInfo = PageHelper.startPage(page, size);
        List<Product> products = productService.selectProduct();
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        List<Product> result = pageInfo.getResult();
        return pageInfo;
    }
    /**
     *  查询商品类目下所有商品信息
     */
    @ApiOperation(value = "商品类目下所有商品",notes ="商品类目下所有商品")
    @RequestMapping(value = "/getProductById",method = RequestMethod.GET)
    public Result getProductById(@RequestParam Integer productId)  {
        List<Product> productById = productService.getProductById(productId);
        return new Result(200,"查询成功",productById);
    }

    @ApiOperation("添加分类")
    @PostMapping("productInsrt")
    public Result productInsrt(@RequestParam String productName){
        productService.insert(productName);
        return new Result(200,"添加成功",productName);
    }
    @ApiOperation("修改分类")
    @PostMapping("productupdate")
    public Result productupdate(@RequestBody Product record){
        productService.updateByPrimaryKey(record);
        return new Result(200,"修改成功",record);
    }
    @ApiOperation("删除分类")
    @PostMapping("productdelete")
    public Result productdelete(@RequestBody Integer productId){
        productService.deleteByPrimaryKey(productId);
        return new Result(200,"删除成功",productId);
    }

    @ApiOperation("id查询分类")
    @GetMapping("productselect")
    public Result productselect(@RequestParam Integer productId){
        Product product = productService.selectByPrimaryKey(productId);
        return new Result(200,"查询成功",product);
    }

}
