package com.xb.wechatmp.service.weixin.storage;

import com.xb.wechatmp.service.weixin.http.ApacheHttpClientBuilder;
import com.xb.wechatmp.util.ToStringUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * WxMpInMemoryConfigStorage
 * 基于内存的微信配置provider，应该将这些配置持久化
 * 2017-08-21 15:24
 **/
@Service
public class WxMpConfigStorageImpl implements WxMpConfigStorage {
    /**
     * 公众号或企业号，开发者设置的token
     */
    private volatile String token;
    /**
     * 公众号或微信号，微信端根据用户返回的加密后的token
     */
    private volatile String accessToken;
    private volatile String appId;
    private volatile String secret;
    private volatile String aesKey;
    private volatile long expiresTime;

    private volatile String httpProxyHost;
    private volatile int httpProxyPort;
    private volatile String httpProxyUsername;
    private volatile String httpProxyPassword;

    protected Lock accessTokenLock = new ReentrantLock();

    private volatile ApacheHttpClientBuilder apacheHttpClientBuilder;

    @Override
    public String getAccessToken() {
        return this.accessToken;
    }

    @Override
    public synchronized void updateAccessToken(String accessToken, int expiresInSeconds) {
        this.accessToken = accessToken;
        this.expiresTime = System.currentTimeMillis() + (expiresInSeconds - 200) * 1000L;
    }

    @Override
    public String getAppId() {
        return appId;
    }

    @Override
    public String getToken() {
        return this.token;
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

    @Override
    public String getHttpProxyUsername() {
        return this.httpProxyUsername;
    }

    @Override
    public String getHttpProxyPassword() {
        return this.httpProxyPassword;
    }

    @Override
    public Lock getAccessTokenLock() {
        return this.accessTokenLock;
    }

    @Override
    public ApacheHttpClientBuilder getApacheHttpClientBuilder() {
        return this.apacheHttpClientBuilder;
    }

    @Override
    public String toString() {
        return ToStringUtils.toSimpleString(this);
    }

    @Override
    public boolean autoRefreshToken() {
        return true;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setToken(String token) {
        this.token = token;
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

    public void setHttpProxyUsername(String httpProxyUsername) {
        this.httpProxyUsername = httpProxyUsername;
    }

    public void setHttpProxyPassword(String httpProxyPassword) {
        this.httpProxyPassword = httpProxyPassword;
    }

    public void setApacheHttpClientBuilder(ApacheHttpClientBuilder apacheHttpClientBuilder) {
        this.apacheHttpClientBuilder = apacheHttpClientBuilder;
    }

    public void setAccessTokenLock(Lock accessTokenLock) {
        this.accessTokenLock = accessTokenLock;
    }
}
