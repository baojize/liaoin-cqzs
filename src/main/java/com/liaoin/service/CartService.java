package com.liaoin.service;

import com.liaoin.common.Cart;
import com.liaoin.entity.ProductList;
import com.liaoin.entity.User;
import java.io.IOException;
import java.math.BigDecimal;


/**
 * @Author: ldw
 * @Date: created in 10:25 2018/8/9
 * @Description:
 */
public interface CartService {
    Cart getCart(User loginUser) throws IOException;

    void addToCart(User loginUser, ProductList productList, BigDecimal num) throws IOException;

    void updateCart(User loginUser, Cart cart);

}
