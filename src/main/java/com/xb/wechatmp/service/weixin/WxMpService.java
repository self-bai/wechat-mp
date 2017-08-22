package com.xb.wechatmp.service.weixin;

import com.xb.wechatmp.util.weixin.exception.WxErrorException;

/**
 * 微信API的Service
 * 2017-08-21 15:08
 **/
public interface WxMpService {
    /**
     * 获取access_token
     */
    String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    /**
     * <pre>
     * 验证消息的确来自微信服务器
     * 详情请见: http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421135319&token=&lang=zh_CN
     * </pre>
     */
    boolean checkSignature(String timestamp, String nonce, String signature);

    /**
     * 获取access_token, 不强制刷新access_token
     *
     * @see #getAccessToken(boolean)
     */
    String getAccessToken() throws WxErrorException;

    /**
     * <pre>
     * 获取access_token，本方法线程安全
     * 且在多线程同时刷新时只刷新一次，避免超出2000次/日的调用次数上限
     *
     * 另：本service的所有方法都会在access_token过期是调用此方法
     *
     * 程序员在非必要情况下尽量不要主动调用此方法
     *
     * 详情请见: http://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140183&token=&lang=zh_CN
     * </pre>
     *
     * @param forceRefresh 强制刷新
     */
    String getAccessToken(boolean forceRefresh) throws WxErrorException;


    /**
     * 当本Service没有实现某个API的时候，可以用这个，针对所有微信API中的GET请求
     */
    String get(String url, String queryParam);

    /**
     * 当本Service没有实现某个API的时候，可以用这个，针对所有微信API中的POST请求
     */
    String post(String url, String postData);

    void initHttp();

    /**
     * 注入 {@link WxMpConfigStorage} 的实现，并完成initHttp，因此不使用注解方式注入
     */
    void setWxMpConfigStorage(WxMpConfigStorage wxConfigProvider);
}
