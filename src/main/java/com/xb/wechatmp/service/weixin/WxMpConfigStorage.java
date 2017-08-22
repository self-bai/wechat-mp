package com.xb.wechatmp.service.weixin;

import com.xb.wechatmp.service.weixin.http.ApacheHttpClientBuilder;

import java.util.concurrent.locks.Lock;

/**
 * 2017-08-21 15:21
 **/
public interface WxMpConfigStorage {

    String getAccessToken();

    /**
     * 应该是线程安全的
     *
     * @param accessToken      新的accessToken值
     * @param expiresInSeconds 过期时间，以秒为单位
     */
    void updateAccessToken(String accessToken, int expiresInSeconds);

    String getAppId();

    String getSecret();

    String getAesKey();

    long getExpiresTime();

    boolean isAccessTokenExpired();

    void expireAccessToken();

    String getHttpProxyHost();

    int getHttpProxyPort();

    String getHttpProxyUsername();

    String getHttpProxyPassword();

    Lock getAccessTokenLock();

    /**
     * http client builder
     *
     * @return ApacheHttpClientBuilder
     */
    ApacheHttpClientBuilder getApacheHttpClientBuilder();

    public boolean autoRefreshToken();
}
