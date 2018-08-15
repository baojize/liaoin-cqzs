package com.liaoin.service.impl;

import com.liaoin.common.CartOption;
import com.liaoin.common.Cart;
import com.liaoin.entity.ProductList;
import com.liaoin.entity.User;
import com.liaoin.service.CartService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.ibatis.annotations.One;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpCookie;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


/**
 * @Author: ldw
 * @Date: created in 10:25 2018/8/9
 * @Description:
 */
@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private HttpSession session;

  /*  @Resource
    private RedisTemplate<String, Object> redisTemplate;
*/
    @Override
    public Cart getCart(User loginUser)throws IOException {
        //获取购物车
        Cart cart = (Cart) session.getAttribute("cart");
        return cart;
       /* Cart cart = (Cart) redisTemplate.boundHashOps("cart").get(loginUser.getUserMobile());
        return cart;*/
    }

    @Override
    public void addToCart(User loginUser, ProductList productList, BigDecimal num) throws IOException {
        // 封装商品数据
        CartOption cartOption = new CartOption();
        cartOption.setProductList(productList);
        cartOption.setNum(num);
        //获取购物车
        Cart cart = getCart(loginUser);
        //判断购物车是否为空
        if (cart == null) {
            //如果为空,就创建一个
            cart = new Cart();
            cart.getCartOptionList().add(cartOption);
            //将购物车加入到sessoin
            session.setAttribute("cart",cart);
            return;
           /* redisTemplate.boundHashOps("cart").put(loginUser.getUserMobile(), cart); */  // 将购物车加入redis
          /*  return;*/

        }
        //判断商品是否存在于购物车
        int indexOf = cart.getCartOptionList().indexOf(cartOption);
        if (indexOf > -1) {
            //存在
            CartOption cartOption1 = cart.getCartOptionList().get(indexOf);
            cartOption1.setNum(cartOption1.getNum().add(num));
        }else {
            cart.getCartOptionList().add(cartOption);
        }
        session.setAttribute("cart",cart);
       /* redisTemplate.boundHashOps("cart").put(loginUser.getUserMobile(),cart);*/
    }

    @Override
    public void updateCart(User loginUser, Cart cart) {
    }
}
