package com.xb.wechatmp.domain.weixin.message;

import com.thoughtworks.xstream.converters.basic.StringConverter;

/**
 * 2017-08-22 14:34
 **/
public class XStreamCDataConverter extends StringConverter {

    @Override
    public String toString(Object obj) {
        return "<![CDATA[" + super.toString(obj) + "]]>";
    }
}
