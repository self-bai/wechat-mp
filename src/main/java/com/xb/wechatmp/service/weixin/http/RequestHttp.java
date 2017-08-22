package com.xb.wechatmp.service.weixin.http;

import com.xb.wechatmp.service.weixin.http.HttpType;

/**
 * 2017-08-21 16:16
 **/
public interface RequestHttp<H, P> {
    /**
     * 返回httpClient
     */
    H getRequestHttpClient();

    P getRequestHttpProxy();

    HttpType getRequestType();
}
