package com.liaoin.mapper;

import com.liaoin.entity.Order;
import com.liaoin.entity.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteOrderByPrimaryKey(String id);

    int insertOrder(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectOrderByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateOrderByPrimaryKey(Order record);

    List<Order> listOrder();
}