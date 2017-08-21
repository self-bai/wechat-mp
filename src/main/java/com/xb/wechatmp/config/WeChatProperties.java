package com.xb.wechatmp.config;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 2017-08-21 14:44
 **/
@ConfigurationProperties(prefix = "wechat.cp")
public class WeChatProperties {

    /* 微信公众号的appId */
    private String appId;
    /* 微信公众号的app secret */
    private String secret;
    /* 微信公众号的token */
    private String token;
    /* 微信公众号的EncodingAESKey */
    private String aeskey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAeskey() {
        return aeskey;
    }

    public void setAeskey(String aeskey) {
        this.aeskey = aeskey;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this,
                ToStringStyle.MULTI_LINE_STYLE);
    }
}
