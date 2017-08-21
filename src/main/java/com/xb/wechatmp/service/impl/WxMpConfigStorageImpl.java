package com.xb.wechatmp.service.impl;

import com.xb.wechatmp.service.WxMpConfigStorage;

/**
 * WxMpInMemoryConfigStorage
 * 2017-08-21 15:24
 **/
public class WxMpConfigStorageImpl implements WxMpConfigStorage {
    protected volatile String appId;
    protected volatile String secret;
    protected volatile String token;
    protected volatile String accessToken;
    protected volatile String aesKey;
    protected volatile long expiresTime;

    @Override
    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public boolean isAccessTokenExpired() {
        return false;
    }
}
