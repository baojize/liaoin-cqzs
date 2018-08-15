package com.liaoin.service.impl;

import com.alipay.api.AlipayApiException;
import com.github.wxpay.sdk.WXPayConfig;
import com.liaoin.common.AlipayUtils;
import com.liaoin.common.MyConfig;
import com.liaoin.common.WxpayUtils;
import com.liaoin.entity.Order;
import com.liaoin.entity.SystemAlipay;
import com.liaoin.entity.SystemWxpay;
import com.liaoin.service.PayService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ldw
 * @Date: created in 15:24 2018/8/14
 * @Description:
 */
@Service
@Transactional
public class PayServiceImpl implements PayService {
    @Override
    public String alipay(SystemAlipay systemAlipay, Order order) throws AlipayApiException {
        // 订单编号
        String orderId = order.getId();
        // 订单总金额，以元为单位，精确到小数点后2位
        BigDecimal amount = order.getAmount();
        // 支付宝网关
        String serverUrl = systemAlipay.getServerUrl();
        // 应用编号
        String appId = systemAlipay.getAppId();
        // 应用私钥
        String privateKey = systemAlipay.getPrivateKey();
        // 支付宝公钥
        String alipayPublicKey = systemAlipay.getAlipayPublicKey();
        // 回调地址
        String notifyUrl = systemAlipay.getNotifyUrl();
        // 交易标题
        String subject = systemAlipay.getSubject();
        return AlipayUtils.payByApp(serverUrl,appId,privateKey,alipayPublicKey,notifyUrl,subject,orderId,amount.toString());
    }

    @Override
    public String wxpay(SystemWxpay systemWxpay, Order order) throws Exception {
        WXPayConfig config = new MyConfig(systemWxpay.getAppId(), systemWxpay.getMchId(), systemWxpay.getKey());
        Map<String, String> data = new HashMap<>(16);
        data.put("body", "商品");
        data.put("out_trade_no", order.getId());
        data.put("total_fee", order.getAmount().doubleValue() * 100 + "");
        data.put("spbill_create_ip", systemWxpay.getSpbillCreateIp());
        data.put("notify_url", systemWxpay.getNotifyUrl());
        data.put("trade_type", "APP");
        return WxpayUtils.payByApp(config, data);
    }
}
