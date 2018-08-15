package com.liaoin.service;

import com.liaoin.entity.Broadcast;

import java.util.List;

/**
 * @Author: ldw
 * @Date: created in 15:09 2018/8/10
 * @Description:
 */
public interface BroadcastService {
    List<Broadcast> getBroadcast(Integer size);

    int insert(Broadcast record);

    Broadcast selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(Broadcast record);
}
