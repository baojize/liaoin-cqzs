package com.liaoin.service;

import com.liaoin.entity.Order;
import com.liaoin.entity.SystemAlipay;
import com.alipay.api.AlipayApiException;
import com.liaoin.entity.SystemWxpay;

/**
 * @Author: ldw
 * @Date: created in 15:16 2018/8/14
 * @Description:支付服务
 */
public interface PayService {

    /**
     * 支付宝支付
     *
     * @param systemAlipay 支付宝支付系统参数
     * @param order        订单
     * @return 支付订单信息
     */
    String alipay(SystemAlipay systemAlipay, Order order) throws AlipayApiException;
    /**
     * 微信支付
     *
     * @param systemWxpay 微信支付系统参数
     * @param order       订单
     * @return 预支付的微信订单号
     * @throws Exception 支付出错抛出异常
     */
    String wxpay(SystemWxpay systemWxpay, Order order) throws Exception;
}
