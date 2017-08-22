package com.xb.wechatmp.domain.weixin;

import com.xb.wechatmp.util.weixin.WxGsonBuilder;

import java.io.Serializable;

/**
 * 2017-08-22 9:41
 **/
public class WxError implements Serializable {
    private static final long serialVersionUID = 478725433591055758L;

    private int errorCode;
    private String errorMsg;
    private String json;

    public static WxError fromJson(String json) {
        return WxGsonBuilder.create().fromJson(json, WxError.class);
    }

    @Override
    public String toString() {
        if (this.json != null) {
            return this.json;
        }
        return "错误: Code=" + this.errorCode + ", Msg=" + this.errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
