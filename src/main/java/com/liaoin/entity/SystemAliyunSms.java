package com.liaoin.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ldw
 * @Date: created in 16:20 2018/7/30
 * @Description:
 */
@Data
public class SystemAliyunSms {
    private Integer id;
    //密钥编号
    private String accessKeyId;
    //密钥密码
    private String accessKeySecret;
    //签名
    private String signName;
    //短信模板系统参数列表
    private Set<SystemSmsTemplate> systemSmsTemplateList = new HashSet<>();
}
