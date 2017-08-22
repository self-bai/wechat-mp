package com.xb.wechatmp.util.weixin.jsonadapter;

import com.google.gson.*;
import com.xb.wechatmp.domain.weixin.WxAccessToken;

import java.lang.reflect.Type;

/**
 * 2017-08-22 10:15
 **/
public class WxAccessTokenAdapter implements JsonDeserializer<WxAccessToken> {

    @Override
    public WxAccessToken deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        WxAccessToken accessToken = new WxAccessToken();
        JsonObject accessTokenJsonObject = jsonElement.getAsJsonObject();

        JsonElement access_token = accessTokenJsonObject.get("access_token");
        if (access_token != null && !access_token.isJsonNull()) {
            accessToken.setAccessToken(GsonHelper.getAsString(access_token));
        }
        JsonElement expires_in = accessTokenJsonObject.get("expires_in");
        if (expires_in != null && !expires_in.isJsonNull()) {
            accessToken.setExpiresIn(GsonHelper.getAsPrimitiveInt(expires_in));
        }
        return accessToken;
    }
}
