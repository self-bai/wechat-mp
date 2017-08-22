package com.xb.wechatmp.domain.weixin.builder;

import com.xb.wechatmp.domain.weixin.message.WxMpXmlOutMessage;

/**
 * 2017-08-22 15:05
 **/
public abstract class BaseBuilder<BuilderType, ValueType> {

    protected String toUserName;
    protected String fromUserName;

    @SuppressWarnings("unchecked")
    public BuilderType toUser(String toUser) {
        this.toUserName = toUser;
        return (BuilderType) this;
    }

    @SuppressWarnings("unchecked")
    public BuilderType fromUser(String fromUser) {
        this.fromUserName = fromUser;
        return (BuilderType) this;
    }

    public abstract ValueType build();

    public void setCommon(WxMpXmlOutMessage m) {
        m.setToUserName(this.toUserName);
        m.setFromUserName(this.fromUserName);
        m.setCreateTime(System.currentTimeMillis() / 1000L);
    }
}
