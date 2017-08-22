package com.xb.wechatmp.service.weixin.http.impl;

import com.xb.wechatmp.domain.weixin.WxError;
import com.xb.wechatmp.service.weixin.http.RequestHttp;
import com.xb.wechatmp.util.weixin.exception.WxErrorException;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

/**
 * 2017-08-22 9:37
 **/
public class ApacheHttpClientGetRequestExecutor extends RequestExecutorGetImpl<CloseableHttpClient, HttpHost> {

    public ApacheHttpClientGetRequestExecutor(RequestHttp<CloseableHttpClient, HttpHost> requestHttp){
        super(requestHttp);
    }

    @Override
    public String execute(String uri, String queryParam) throws WxErrorException, IOException {
        if (queryParam != null) {
            if (uri.indexOf('?') == -1) {
                uri += '?';
            }
            uri += uri.endsWith("?") ? queryParam : '&' + queryParam;
        }
        HttpGet httpGet = new HttpGet(uri);
        if (requestHttp.getRequestHttpProxy() != null) {
            RequestConfig config = RequestConfig.custom().setProxy(requestHttp.getRequestHttpProxy()).build();
            httpGet.setConfig(config);
        }

        try (CloseableHttpResponse response = requestHttp.getRequestHttpClient().execute(httpGet)) {
            String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
            WxError error = WxError.fromJson(responseContent);
            if (error.getErrorCode() != 0) {
                throw new WxErrorException(error);
            }
            return responseContent;
        } finally {
            httpGet.releaseConnection();
        }
    }
}
