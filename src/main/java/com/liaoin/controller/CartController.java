package com.liaoin.controller;

import com.liaoin.common.Cart;
import com.liaoin.common.Result;
import com.liaoin.entity.ProductList;
import com.liaoin.entity.User;
import com.liaoin.service.CartService;
import com.liaoin.service.ProductListService;
import com.liaoin.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpCookie;

/**
 * @Author: ldw
 * @Date: created in 17:31 2018/8/1
 * @Description:
 */
@RestController
@Api(value = "购物车模块",description = "CartController",tags = "购物车模块")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductListService productListService;
    @Autowired
    private ProductService productService;

    @ApiOperation("加入购物")
    @RequestMapping(value = "/addToCart", method = RequestMethod.GET)
    public Result addToCart(HttpSession session, @RequestParam Integer productList_Id, @RequestParam BigDecimal num) throws IOException {
        // 1.判断用户是否存在
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return new Result(300, "请登录", null);
        }
        //2.判断商品是否存在
        ProductList productLists = productListService.selectByPrimaryKey(productList_Id);
        if (productLists == null) {
            return new Result(300, "商品不存在", null);
        }
        //3.加入购物车
        cartService.addToCart(loginUser, productLists, num);
        return new Result(200, "加入成功", productLists);
    }

    @ApiOperation("获取购物车")
    @RequestMapping(value = "/getCart", method = RequestMethod.POST)
    public Result getCart(HttpSession session) throws IOException {
        //判断用户是否存在
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return new Result(300, "请登录", null);
        }
        //获取购物车
        Cart cart = cartService.getCart(loginUser);
        if (cart == null) {
            return new Result(300, "购物车空的", null);
        }
        return new Result(200, "获取成功", cart);
    }
    @ApiOperation("删除购物车")
    @RequestMapping(value = "/updateCart", method = RequestMethod.GET)
    public Result updateCart(HttpSession session) throws IOException {
        //判断用户是否存在
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return new Result(300, "请登录", null);
        }
        //获取购物车
        Cart cart = cartService.getCart(loginUser);
        if (cart == null) {
            return new Result(300, "购物车是空的", null);
        }
        session.removeAttribute("cart");
        return new Result(200, "删除成功", cart);
    }
}
