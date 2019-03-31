package com.hacker.framework.net;

import com.hacker.framework.util.LoggerUtil;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.*;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.CodingErrorAction;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hacker on 2019/3/31 0031.
 */
public class ProtocolServiceImpl implements ProtocolService, InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtocolServiceImpl.class);

    private CloseableHttpClient httpClient;

    /**
     * 注意：这里能抛出 IOException 是因为接口中抛出了，注意重新的注意事项
     * @param netRequest
     * @return
     * @throws IOException
     */
    @Override
    public NetResponse get(NetRequest netRequest) throws IOException{
        String url = netRequest.getUrl();
        HttpGet httpGet;

        Map<String, String> urlParam = netRequest.getUrlParam();
        if (urlParam.isEmpty()){
            httpGet = new HttpGet(url);
        }else {
            httpGet = new HttpGet(appendUrlParam(urlParam, url));
        }

        //设置一些必要的请求超时参数
        RequestConfig requestConfig = buidlRequestConfig(netRequest);
        httpGet.setConfig(requestConfig);

        return execute(httpGet);
    }

    @Override
    public NetResponse post(NetRequest netRequest) throws IOException{
        HttpPost httpPost;
        String url = netRequest.getUrl();

        Map<String, String> urlParam = netRequest.getUrlParam();
        if (urlParam.isEmpty()){
            httpPost = new HttpPost(url);
        }else {
            httpPost = new HttpPost(appendUrlParam(urlParam, url));
        }

        Map<String, String> headers = netRequest.getHeaders();
        if (!headers.isEmpty()){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
        }

        httpPost.setEntity(netRequest.getHttpEntity());

        RequestConfig requestConfig = buidlRequestConfig(netRequest);
        httpPost.setConfig(requestConfig);

        return execute(httpPost);
    }

    private RequestConfig buidlRequestConfig(NetRequest netRequest) {
        return RequestConfig.custom().setConnectionRequestTimeout(netRequest.getConnReqTimeout())
                .setConnectTimeout(netRequest.getConnTimeout())
                .setSocketTimeout(netRequest.getSocketTimeout()).build();
    }

    /**
     * 执行请求
     * @param request
     * @return
     */
    private NetResponse execute(HttpUriRequest request) throws IOException{
        NetResponse netResponse = new NetResponse();
        CloseableHttpResponse httpResponse = null;
        try {
             httpResponse = httpClient.execute(request);
             if (null != httpResponse){
                 int statusCode = httpResponse.getStatusLine().getStatusCode();
                 netResponse.setStatusCode(statusCode);
                 HttpEntity entity = httpResponse.getEntity();
                 String netMessage = EntityUtils.toString(entity, "UTF-8");
                 netResponse.setEntryMessage(netMessage);
             }
        }finally {
             if (null != httpResponse){
                 httpResponse.close();
             }
        }
        return netResponse;
    }

    /**
     * 构建参数
     * @param urlParam
     * @param url
     * @return
     */
    private String appendUrlParam(Map<String, String> urlParam, String url) {
        //参数封装成铭值对
        List<NameValuePair> pairs = new ArrayList<>();
        for (Map.Entry<String, String> entry : urlParam.entrySet()) {
            pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        return  url + "?"  + URLEncodedUtils.format(pairs, "UTF-8");
    }

    /**
     * 初始化操作, 到底做了什么好像时 可以访问 https 请求
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

        try {
            System.setProperty("jsse.enableSNIExtension", "false");
            TrustManager[] trustManagers = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};

            TrustManager[] trustManagersExtends = new TrustManager[]{new X509ExtendedTrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s, Socket socket) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s, Socket socket) throws CertificateException {

                }

                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s, SSLEngine sslEngine) throws CertificateException {

                }

                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }};

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustManagersExtends, new java.security.SecureRandom());
            Registry<ConnectionSocketFactory> socketFactory = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1", "TLSv1.1"},
                            null, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER))
                    .build();

            PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(socketFactory);
            SocketConfig socketConfig = SocketConfig.custom()
                    .setTcpNoDelay(true).setSoTimeout(2500).build();
            connectionManager.setDefaultSocketConfig(socketConfig);
            MessageConstraints messageConstraints = MessageConstraints.custom()
                    .setMaxHeaderCount(200).setMaxHeaderCount(2000).build();

            ConnectionConfig connectionConfig = ConnectionConfig.custom()
                    .setMalformedInputAction(CodingErrorAction.IGNORE)
                    .setUnmappableInputAction(CodingErrorAction.IGNORE)
                    .setCharset(Consts.UTF_8)
                    .setMessageConstraints(messageConstraints)
                    .build();

            connectionManager.setDefaultConnectionConfig(connectionConfig);
            connectionManager.setMaxTotal(1000);
            connectionManager.setDefaultMaxPerRoute(200);
            httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        } catch (NoSuchAlgorithmException e) {
            LoggerUtil.error(LOGGER, e, "http client keyManagementException");
        } catch (KeyManagementException e) {
            LoggerUtil.error(LOGGER, e, "http client NoSuchAlgorithmException");
        }
    }
}
