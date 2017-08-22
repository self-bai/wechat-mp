package com.xb.wechatmp.domain.weixin.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.xb.wechatmp.domain.weixin.builder.TextBuilder;
import com.xb.wechatmp.service.weixin.storage.WxMpConfigStorage;
import com.xb.wechatmp.util.weixin.WxMpCryptUtil;

import java.io.Serializable;

/**
 * 2017-08-22 15:09
 **/
@XStreamAlias("xml")
public abstract class WxMpXmlOutMessage implements Serializable {
    private static final long serialVersionUID = -5317569376990751019L;

    @XStreamAlias("ToUserName")
    @XStreamConverter(value = XStreamCDataConverter.class)
    protected String toUserName;

    @XStreamAlias("FromUserName")
    @XStreamConverter(value = XStreamCDataConverter.class)
    protected String fromUserName;

    @XStreamAlias("CreateTime")
    protected Long createTime;

    @XStreamAlias("MsgType")
    @XStreamConverter(value = XStreamCDataConverter.class)
    protected String msgType;

    /**
     * 获得文本消息builder
     */
    public static TextBuilder TEXT() {
        return new TextBuilder();
    }

    @SuppressWarnings("unchecked")
    public String toXml() {
        return XStreamTransformer.toXml((Class<WxMpXmlOutMessage>) this.getClass(), this);
    }

    /**
     * 转换成加密的xml
     *
     * @param wxMpConfigStorage 微信配置存储
     * @return
     */
    public String toEncryptedXml(WxMpConfigStorage wxMpConfigStorage) {
        String plainXml = toXml();
        WxMpCryptUtil pc = new WxMpCryptUtil(wxMpConfigStorage);
        return pc.encrypt(plainXml);
    }

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
