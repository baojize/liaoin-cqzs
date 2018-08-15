package com.liaoin.service.impl;

import com.liaoin.entity.Broadcast;
import com.liaoin.mapper.BroadcastMapper;
import com.liaoin.service.BroadcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @Author: ldw
 * @Date: created in 15:09 2018/8/10
 * @Description:
 */
@Service
@Transactional
public class BroadcastServiceImpl implements BroadcastService {

    @Autowired
    private BroadcastMapper broadcastMapper;
    @Override
    public List<Broadcast> getBroadcast(Integer size) {
        List<Broadcast> broadcasts = broadcastMapper.getBroadcast(size);
        return broadcasts;
    }

    @Override
    public int insert(Broadcast record) {
       return broadcastMapper.insert(record);
    }

    @Override
    public Broadcast selectByPrimaryKey(Integer id) {
        return broadcastMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return broadcastMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(Broadcast record) {
        return broadcastMapper.updateByPrimaryKey(record);
    }
}
