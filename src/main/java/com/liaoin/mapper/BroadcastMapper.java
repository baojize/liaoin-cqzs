package com.liaoin.mapper;

import com.liaoin.entity.Broadcast;
import com.liaoin.entity.BroadcastExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BroadcastMapper {
    long countByExample(BroadcastExample example);

    int deleteByExample(BroadcastExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Broadcast record);

    int insertSelective(Broadcast record);

    List<Broadcast> selectByExample(BroadcastExample example);

    Broadcast selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Broadcast record, @Param("example") BroadcastExample example);

    int updateByExample(@Param("record") Broadcast record, @Param("example") BroadcastExample example);

    int updateByPrimaryKeySelective(Broadcast record);

    int updateByPrimaryKey(Broadcast record);

    List<Broadcast> getBroadcast(Integer size);
}