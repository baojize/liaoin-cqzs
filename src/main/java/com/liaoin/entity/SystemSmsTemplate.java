package com.liaoin.entity;

import lombok.Data;

/**
 * @Author: ldw
 * @Date: created in 16:22 2018/7/30
 * @Description:
 */
@Data
public class SystemSmsTemplate {
    private Integer id;
    //模板名称
    private String templateName;
    //模板编号
    private String templateCode;
    //阿里云短信系统参数
    private SystemAliyunSms systemAliyunSms;


}
