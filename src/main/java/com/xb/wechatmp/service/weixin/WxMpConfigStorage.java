package com.xb.wechatmp.service.weixin;

/**
 * 2017-08-21 15:21
 **/
public interface WxMpConfigStorage {

    String getAccessToken();

    String getAppId();

    String getSecret();

    String getAesKey();

    long getExpiresTime();

    boolean isAccessTokenExpired();

    void expireAccessToken();

    String getHttpProxyHost();

    int getHttpProxyPort();

}
