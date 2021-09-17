package com.example.maka.utils;

package com.rx.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtils {
    public static String CONTENTTYPE_FORM = "application/x-www-form-urlencoded";
    public static String CONTENTTYPE_JSON = "application/json";
    public static String CONTENTTYPE_XML = "application/x-www-form-urlencodedtext/html";

    public static String simplePostForm(String url, Map<String, String> param) throws Exception {
        return sendHttpsPost(url, null, param, CONTENTTYPE_FORM, "UTF-8");
    }

    public static String simplePostJson(String url, String paramJsonString) throws Exception {
        return sendHttpsPost(url, null, paramJsonString, CONTENTTYPE_JSON, "UTF-8");
    }

    public static String simplePostXML(String url, String paramXmlString) throws Exception {
        return sendHttpsPost(url, null, paramXmlString, CONTENTTYPE_XML, "UTF-8");
    }

    public static String sendHttpsPost(String url, Map<String, String> headerMap, String entityContent,
                                       String contentType, String charSet) {
        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

            }
        };

        SSLContext sc = SSLContext.getInstance("TLSv1.2");
        sc.init(null, new TrustManager[] { trustManager }, null);
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sc);

        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        httpPost = new HttpPost(url);
        if (null != headerMap && !headerMap.isEmpty()) {
            Set<String> keySet = headerMap.keySet();
            for (String key : keySet) {
                String v = headerMap.get(key);
                if (StringUtils.isNotEmpty(v)) {
                    httpPost.addHeader(key, v);
                }
            }
        }
        StringEntity entity = new StringEntity(entityContent, charSet);
        entity.setContentEncoding(charSet);
        entity.setContentType(contentType);
        httpPost.setEntity(entity);
        HttpResponse response = httpClient.execute(httpPost);
        if (response != null) {
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                result = EntityUtils.toString(resEntity, charSet);
            }
        }
        return result;
    }

    public static String sendHttpsPost(String url, Map<String, String> headerMap, Map<String, String> params,
                                       String contentType, String charSet) throws Exception {
        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        SSLContext sc = SSLContext.getInstance("TLSv1.2");
        sc.init(null, new TrustManager[] { trustManager }, null);
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sc);
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        HttpPost post = new HttpPost(url);
        if (null != headerMap && !headerMap.isEmpty()) {
            Set<String> keySet = headerMap.keySet();
            for (String key : keySet) {
                String v = headerMap.get(key);
                if (StringUtils.isNotEmpty(v)) {
                    post.addHeader(key, v);
                }
            }
        }
        post.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, charSet);
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        Set set = params.keySet();
        for (Object str : set) {
            nameValuePairs.add(new BasicNameValuePair(str.toString(), params.get(str)));
        }
        post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));

        CloseableHttpResponse response = httpclient.execute(post);
        String returnStr = "";
        try {
            HttpEntity entity = response.getEntity();
            returnStr = EntityUtils.toString(entity);
        } finally {
            response.close();
        }
        return returnStr;
    }
}