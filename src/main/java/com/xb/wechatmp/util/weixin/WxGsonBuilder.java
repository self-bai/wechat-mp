package com.xb.wechatmp.util.weixin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xb.wechatmp.domain.weixin.WxAccessToken;
import com.xb.wechatmp.domain.weixin.WxError;
import com.xb.wechatmp.domain.weixin.menu.WxMenu;
import com.xb.wechatmp.util.weixin.jsonadapter.WxAccessTokenAdapter;
import com.xb.wechatmp.util.weixin.jsonadapter.WxErrorAdapter;
import com.xb.wechatmp.util.weixin.jsonadapter.WxMenuGsonAdapter;

/**
 * 2017-08-22 10:09
 **/
public class WxGsonBuilder {

    public static final GsonBuilder INSTANCE = new GsonBuilder();

    static {
        INSTANCE.disableHtmlEscaping();
        INSTANCE.registerTypeAdapter(WxAccessToken.class, new WxAccessTokenAdapter());
        INSTANCE.registerTypeAdapter(WxError.class, new WxErrorAdapter());
        INSTANCE.registerTypeAdapter(WxMenu.class, new WxMenuGsonAdapter());
    }

    public static Gson create() {
        return INSTANCE.create();
    }

}
