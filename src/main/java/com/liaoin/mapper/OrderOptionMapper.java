package com.liaoin.mapper;

import com.liaoin.entity.OrderOption;
import com.liaoin.entity.OrderOptionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderOptionMapper {
    long countByExample(OrderOptionExample example);

    int deleteByExample(OrderOptionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderOption record);

    int insertSelective(OrderOption record);

    List<OrderOption> selectByExample(OrderOptionExample example);

    OrderOption selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderOption record, @Param("example") OrderOptionExample example);

    int updateByExample(@Param("record") OrderOption record, @Param("example") OrderOptionExample example);

    int updateByPrimaryKeySelective(OrderOption record);

    int updateByPrimaryKey(OrderOption record);
}