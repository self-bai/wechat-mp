package com.xb.wechatmp.service;

/**
 * 2017-08-21 15:21
 **/
public interface WxMpConfigStorage {

    String getAccessToken();

    boolean isAccessTokenExpired();


}
