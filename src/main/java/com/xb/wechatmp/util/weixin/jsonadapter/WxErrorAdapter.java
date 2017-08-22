package com.xb.wechatmp.util.weixin.jsonadapter;

import com.google.gson.*;
import com.xb.wechatmp.domain.weixin.WxError;

import java.lang.reflect.Type;

/**
 * 2017-08-22 10:28
 **/
public class WxErrorAdapter implements JsonDeserializer<WxError> {

    @Override
    public WxError deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        WxError wxError = new WxError();
        JsonObject wxErrorJsonObject = jsonElement.getAsJsonObject();

        JsonElement errcode = wxErrorJsonObject.get("errcode");
        if (errcode != null && !errcode.isJsonNull()) {
            wxError.setErrorCode(GsonHelper.getAsPrimitiveInt(errcode));
        }
        JsonElement errmsg = wxErrorJsonObject.get("errmsg");
        if (errmsg != null && !errmsg.isJsonNull()) {
            wxError.setErrorMsg(GsonHelper.getAsString(errmsg));
        }
        wxError.setJson(jsonElement.toString());
        return wxError;
    }
}
