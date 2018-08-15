package com.liaoin.entity;

import lombok.Data;

import java.io.Serializable;


/**
 * @Author: ldw
 * @Date: created in 10:23 2018/8/3
 * @Description:模板实体类
 */
@Data
public class Template implements Serializable {
    private Integer id;
    //模板名称
    private String name;
    private String isDelete;

}
