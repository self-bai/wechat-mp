package com.xb.wechatmp.service.weixin.impl;

import com.xb.wechatmp.service.weixin.WxMpConfigStorage;
import org.springframework.stereotype.Service;

/**
 * WxMpInMemoryConfigStorage
 * 基于内存的微信配置provider，在实际生产环境中应该将这些配置持久化
 *
 * 2017-08-21 15:24
 **/
@Service
public class WxMpConfigStorageImpl implements WxMpConfigStorage {
    private volatile String appId;
    private volatile String secret;
    private volatile String accessToken;
    private volatile String aesKey;
    private volatile long expiresTime;

    private volatile String httpProxyHost;
    private volatile int httpProxyPort;
    private volatile String httpProxyUsername;
    private volatile String httpProxyPassword;

    @Override
    public String getAccessToken() {
        return this.accessToken;
    }

    @Override
    public String getAppId() {
        return appId;
    }

    @Override
    public String getSecret() {
        return secret;
    }

    @Override
    public String getAesKey() {
        return aesKey;
    }

    @Override
    public long getExpiresTime() {
        return expiresTime;
    }

    @Override
    public boolean isAccessTokenExpired() {
        return System.currentTimeMillis() > this.expiresTime;
    }

    @Override
    public void expireAccessToken() {
        this.expiresTime = 0;
    }

    @Override
    public String getHttpProxyHost() {
        return this.httpProxyHost;
    }

    @Override
    public int getHttpProxyPort() {
        return this.httpProxyPort;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }

    public void setExpiresTime(long expiresTime) {
        this.expiresTime = expiresTime;
    }

    public void setHttpProxyHost(String httpProxyHost) {
        this.httpProxyHost = httpProxyHost;
    }

    public void setHttpProxyPort(int httpProxyPort) {
        this.httpProxyPort = httpProxyPort;
    }
}
