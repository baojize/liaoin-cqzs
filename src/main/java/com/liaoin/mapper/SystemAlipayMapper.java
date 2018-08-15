package com.liaoin.mapper;

import com.liaoin.entity.SystemAlipay;
import com.liaoin.entity.SystemAlipayExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemAlipayMapper {
    long countByExample(SystemAlipayExample example);

    int deleteByExample(SystemAlipayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemAlipay record);

    int insertSelective(SystemAlipay record);

    List<SystemAlipay> selectByExample(SystemAlipayExample example);

    SystemAlipay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemAlipay record, @Param("example") SystemAlipayExample example);

    int updateByExample(@Param("record") SystemAlipay record, @Param("example") SystemAlipayExample example);

    int updateByPrimaryKeySelective(SystemAlipay record);

    int updateByPrimaryKey(SystemAlipay record);
}