package com.xb.wechatmp.util.weixin.exception;

import com.xb.wechatmp.domain.weixin.WxError;

/**
 * 2017-08-22 10:56
 **/
public class WxErrorException extends Exception {
    private static final long serialVersionUID = 1964976050661509141L;

    private WxError error;

    public WxErrorException(WxError error) {
        super(error.toString());
        this.error = error;
    }

    public WxErrorException(WxError error, Throwable cause) {
        super(error.toString(), cause);
        this.error = error;
    }

    public WxError getError() {
        return this.error;
    }
}
