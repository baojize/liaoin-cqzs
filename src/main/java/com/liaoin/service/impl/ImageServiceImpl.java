package com.liaoin.service.impl;

import com.liaoin.entity.Image;
import com.liaoin.mapper.ImageMapper;
import com.liaoin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: ldw
 * @Date: created in 17:36 2018/8/7
 * @Description:
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageMapper imageMapper;
    @Override
    public int insert(Image record) {
        return imageMapper.insert(record);
    }
}
