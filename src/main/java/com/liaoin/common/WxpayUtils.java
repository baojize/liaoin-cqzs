package com.liaoin.common;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;

import java.util.Map;

/**
 * @Author: ldw
 * @Date: created in 16:16 2018/8/14
 * @Description:微信支付工具栏
 */
public class WxpayUtils {
    /**
     * @param config 微信支付配置
     * @param data   微信支付参数
     * @return 返回XML格式的字符串
     * @throws Exception 抛出异常
     */
    public static String payByApp(WXPayConfig config, Map<String, String> data) throws Exception {
        WXPay wxPay = new WXPay(config);
        Map<String, String> response = wxPay.unifiedOrder(data);
        if (!("SUCCESS".equals(response.get("return_code")) && "SUCCESS".equals(response.get("result_code")))) {
            throw new RuntimeException(response.get("return_code") + "::" + response.get("return_msg"));
        }
        return response.get("prepay_id");
    }
}
