package com.xb.wechatmp.service.weixin;

import com.xb.wechatmp.domain.weixin.message.WxMpXmlMessage;
import com.xb.wechatmp.domain.weixin.message.WxMpXmlOutMessage;
import com.xb.wechatmp.util.weixin.exception.WxErrorException;

import java.util.Map;

/**
 * 处理微信推送消息的处理器接口
 * 2017-08-22 15:28
 **/
public interface WxMpMessageHandler {

    /**
     * @param wxMessage   微信端要发送的信息对象
     * @param context     上下文，如果handler或interceptor之间有信息要传递，可以用这个
     * @param wxMpService 微信调用服务接口
     * @return xml格式的消息，如果在异步规则里处理的话，可以返回null
     * @throws WxErrorException
     */
    WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context,
                             WxMpService wxMpService) throws WxErrorException;
}
