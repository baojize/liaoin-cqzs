package com.liaoin.entity;

import lombok.Data;

/**
 * @Author: ldw
 * @Date: created in 9:51 2018/7/27
 * @Description:返回json数据的实体类
 */
@Data
public class Result {
    private Integer status;
    private String message;
    private Object data;

}
