package com.liaoin.service.impl;

import com.liaoin.common.Cart;
import com.liaoin.common.CartOption;
import com.liaoin.common.IdUtils;
import com.liaoin.common.Result;
import com.liaoin.entity.Order;
import com.liaoin.entity.OrderOption;
import com.liaoin.entity.ProductList;
import com.liaoin.entity.User;
import com.liaoin.mapper.OrderMapper;
import com.liaoin.mapper.ProductListMapper;
import com.liaoin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 17:20 2018/8/2
 * @Description:
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

  /*  @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    */
    @Autowired
    private ProductListMapper productListMapper;


    @Override
    public int insertOrder(Order record) {
        return orderMapper.insertOrder(record);
    }

    @Override
    public Order selectOrderByPrimaryKey(String id) {
        return orderMapper.selectOrderByPrimaryKey(id);
    }

    @Override
    public Integer deleteOrderByPrimaryKey(String id) {
        int i = orderMapper.deleteOrderByPrimaryKey(id);
        return i;
    }

    @Override
    public int updateOrderByPrimaryKey(Order record) {
        return orderMapper.updateOrderByPrimaryKey(record);
    }

    @Override
    public List<Order> listOrder() {
        return orderMapper.listOrder();
    }


    @Override
    public Result submit(User loginUser, Order order, HttpSession session) {
        //session购物车
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            for (OrderOption orderOption : order.getOrderOptionList()) {
                List<CartOption> cartOptionList = cart.getCartOptionList();
                for (int i = cartOptionList.size() - 1 ;i>=0;i--) {
                    CartOption cartOption = cartOptionList.get(i);
                    if (orderOption.getProductLists().equals(cartOption.getProductList())) {
                        cartOptionList.remove(i);
                    }
                }
            }
            if (cart.getCartOptionList().size() == 0) {
               session.removeAttribute("cart");
            }else{
                session.setAttribute("cart",cart);
            }
        }
        //校验订单信息
        double orderNum = 0D;
        double orderMoney = 0D;
        for (OrderOption orderOption : order.getOrderOptionList()) {
            //校验商品小计
            ProductList productLists = productListMapper.selectByPrimaryKey(orderOption.getProductLists().getProductListId());
            orderOption.setProductLists(productLists);
            double money = productLists.getProductListPrice().doubleValue() * orderOption.getNum().doubleValue();
            if (orderOption.getMoney().doubleValue() != money) {
                return new Result(300, "商品" + productLists.getProductListId() + "小计异常", null);
            }
            orderNum += orderOption.getNum().doubleValue();
            orderMoney += money;
        }

        // 2.2 校验订单金额
        if (order.getMoney().doubleValue() != orderMoney) {
            return new Result(300, "订单金额异常", null);
        }
        // 2.3 校验商品数量
        if (order.getNum().doubleValue() != orderNum) {
            return new Result(300, "商品数量异常", null);
        }
        // 2.4 校验订单总金额
        if (order.getAmount().doubleValue() != orderMoney) {
            return new Result(300, "订单总金额异常", null);
        }
        // 3.保存订单信息
        order.setOrderId(IdUtils.makeOrderNum());
        order.setStatus("1");
        order.setCreattime(new Date());
        order.setUser(loginUser);
        for (OrderOption orderOption : order.getOrderOptionList()) {
            orderOption.setOrder(order);
        }
        orderMapper.insertSelective(order);
        return new Result(200,"订单生成成功",order);
    }

}
