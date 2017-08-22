package com.xb.wechatmp.domain.weixin.builder;

import com.xb.wechatmp.domain.weixin.message.WxMpXmlOutTextMessage;

/**
 * 文本消息Builder
 * 2017-08-22 15:18
 **/
public final class TextBuilder extends BaseBuilder<TextBuilder, WxMpXmlOutTextMessage> {

    private String content;

    public TextBuilder content(String content) {
        this.content = content;
        return this;
    }

    @Override
    public WxMpXmlOutTextMessage build() {
        WxMpXmlOutTextMessage m = new WxMpXmlOutTextMessage();
        setCommon(m);
        m.setContent(this.content);
        return m;
    }

}
