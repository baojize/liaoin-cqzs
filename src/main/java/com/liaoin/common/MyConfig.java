package com.liaoin.common;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

/**
 * @Author: ldw
 * @Date: created in 16:05 2018/8/14
 * @Description:微信支付配置类
 */
public class MyConfig implements WXPayConfig {
    private String appID;
    private String mchID;
    private String key;

    public MyConfig(String appID, String mchID, String key) {
        this.appID = appID;
        this.mchID = mchID;
        this.key = key;

    }
    @Override
    public String getAppID() {
        return null;
    }

    @Override
    public String getMchID() {
        return null;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}
