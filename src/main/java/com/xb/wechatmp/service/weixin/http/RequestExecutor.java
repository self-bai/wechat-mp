package com.xb.wechatmp.service.weixin.http;

import com.xb.wechatmp.util.weixin.exception.WxErrorException;

import java.io.IOException;

/**
 * 2017-08-21 17:05
 **/
public interface RequestExecutor<T, E> {

    /**
     * @param uri  uri
     * @param data 数据
     */
    T execute(String uri, E data) throws IOException, WxErrorException;
}
