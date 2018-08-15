package com.liaoin.service;

import com.liaoin.common.Result;
import com.liaoin.entity.Order;
import com.liaoin.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 17:19 2018/8/2
 * @Description:
 */
public interface OrderService {

    int insertOrder(Order record);

    Order selectOrderByPrimaryKey(String id);

    Integer deleteOrderByPrimaryKey(String id);

    int updateOrderByPrimaryKey(Order record);

    List<Order> listOrder();

    /**
     * 提交订单
     */
    Result submit(User loginUser, Order order, HttpSession session);
}
