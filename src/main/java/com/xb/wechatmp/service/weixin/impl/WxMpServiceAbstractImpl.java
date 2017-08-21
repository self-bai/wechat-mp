package com.xb.wechatmp.service.weixin.impl;

import com.xb.wechatmp.service.weixin.http.RequestHttp;
import com.xb.wechatmp.service.weixin.WxMpConfigStorage;
import com.xb.wechatmp.service.weixin.WxMpService;
import com.xb.wechatmp.util.weixin.crypto.SHA1;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 2017-08-21 15:17
 **/
@Service
public abstract class WxMpServiceAbstractImpl<H, P> implements WxMpService, RequestHttp<H, P> {

    private final Logger log = Logger.getLogger(WxMpServiceAbstractImpl.class);
    private WxMpConfigStorage wxMpConfigStorage;

    @Override
    public boolean checkSignature(String timestamp, String nonce, String signature) {
        try {
            return SHA1.gen(this.getWxMpConfigStorage().getAccessToken(), timestamp, nonce).equals(signature);
        } catch (Exception e) {
            this.log.error("Checking signature failed, and the reason is :" + e.getMessage());
            return false;
        }
    }

    @Override
    public String getAccessToken() {
        return getAccessToken(false);
    }

    @Override
    public String get(String url, String queryParam) {
//        return execute(SimpleGetRequestExecutor.create(this), url, queryParam);
        return null;
    }

    @Override
    public String post(String url, String postData) {
        return null;
    }

    @Override
    public void setWxMpConfigStorage(WxMpConfigStorage wxConfigProvider) {
        this.wxMpConfigStorage = wxConfigProvider;
        this.initHttp();
    }

    public WxMpConfigStorage getWxMpConfigStorage() {
        return this.wxMpConfigStorage;
    }
}
