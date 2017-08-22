package com.xb.wechatmp.domain.weixin;

import com.xb.wechatmp.util.weixin.WxGsonBuilder;

import java.io.Serializable;

/**
 * 2017-08-22 10:11
 **/
public class WxAccessToken implements Serializable {
    private static final long serialVersionUID = 3688478976162060448L;

    private String accessToken;
    private int expiresIn = -1;

    public static WxAccessToken fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxAccessToken.class);
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}
