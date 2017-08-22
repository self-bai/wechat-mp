package com.xb.wechatmp.service.weixin.http.impl;

import com.xb.wechatmp.service.weixin.http.RequestExecutor;
import com.xb.wechatmp.service.weixin.http.RequestHttp;

/**
 * 简单的GET请求执行器，请求的参数是String, 返回的结果也是String
 * 2017-08-21 17:07
 **/
public abstract class RequestExecutorGetImpl<H, P> implements RequestExecutor<String, String> {
    protected RequestHttp<H, P> requestHttp;

    public RequestExecutorGetImpl(RequestHttp<H, P> requestHttp) {
        this.requestHttp = requestHttp;
    }

    public static RequestExecutor<String, String> create(RequestHttp requestHttp) {
        switch (requestHttp.getRequestType()) {
            case APACHE_HTTP:
                return new ApacheHttpClientGetRequestExecutor(requestHttp);
            default:
                throw new IllegalArgumentException("非法请求参数");
        }
    }
}
