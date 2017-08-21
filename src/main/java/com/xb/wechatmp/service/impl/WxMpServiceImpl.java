package com.xb.wechatmp.service.impl;

import com.xb.wechatmp.service.WxMpConfigStorage;
import com.xb.wechatmp.service.WxMpService;
import com.xb.wechatmp.util.weixin.crypto.SHA1;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 2017-08-21 15:17
 **/
@Service
public class WxMpServiceImpl implements WxMpService {

    private final Logger log = Logger.getLogger(WxMpServiceImpl.class);
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
        return null;
    }

    @Override
    public String getAccessToken(boolean forceRefresh) {
        return null;
    }

    @Override
    public String get(String url, String queryParam) {
        return null;
    }

    @Override
    public String post(String url, String postData) {
        return null;
    }

    public WxMpConfigStorage getWxMpConfigStorage() {
        return this.wxMpConfigStorage;
    }
}
