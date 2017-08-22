package com.xb.wechatmp.service.weixin.impl;

import com.xb.wechatmp.domain.weixin.message.WxMpXmlMessage;
import com.xb.wechatmp.domain.weixin.message.WxMpXmlOutMessage;
import com.xb.wechatmp.service.weixin.WxMpMessageHandler;
import com.xb.wechatmp.service.weixin.WxMpService;
import com.xb.wechatmp.util.weixin.exception.WxErrorException;

import java.util.Map;

/**
 * 文本消息发送处理器实现
 * 2017-08-22 15:33
 **/
public class WxMpTextMessageHandler implements WxMpMessageHandler {

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context,
                                    WxMpService wxMpService) throws WxErrorException {
        return WxMpXmlOutMessage.TEXT().content(wxMessage.getContent())
                .fromUser(wxMessage.getFromUser())
                .toUser(wxMessage.getToUser()).build();
    }
}
