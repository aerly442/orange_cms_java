package com.gfrjxz.cms.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletRequest;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestTool {

    private static final String HEADER_CONTENT_JSON = "application/json";

    private static final String DEFAULT_CHARSET = "UTF-8";

    private static PoolingHttpClientConnectionManager cm = null;

    private static ObjectMapper mapper = new ObjectMapper();

    private static CloseableHttpClient httpClient;



    /**
     * 记录开放平台请求结果
     */
    public static class Response {
        /**
         * 该请求的 http 状态码
         * 200 为正常的返回结果
         */
        private int status;

        /**
         * 请求返回消息
         * 当 status == 200 时会返回 response body 中的字符串
         * 当 status !== 200 时会返回具体的错误信息
         */
        private String result;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }

    static{
        cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(500);
        cm.setDefaultMaxPerRoute(50);

        RequestConfig globalConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(1000)         // 连接池获取连接超时
                .setConnectTimeout(1000)                   // 连接建立超时
                .setSocketTimeout(5000)                    // 等待响应超时
                .setCookieSpec(CookieSpecs.IGNORE_COOKIES)
                .build();

        httpClient = HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(globalConfig).build();
    }

    private static CloseableHttpClient getHttpClient(){
        return httpClient;
    }

    public static <T> T doGet(String requestUrl, Map<String, String> paramMap, Class<T> type) throws IOException {
        return mapper.readValue(doGet(requestUrl, paramMap), type);
    }

    public static <T> T doGet(String requestUrl, Map<String, String> paramMap, TypeReference<T> typeReference) throws IOException {
        return mapper.readValue(doGet(requestUrl, paramMap), typeReference);
    }

    public static String doGet(String requestUrl, Map<String, String> paramMap) throws IOException {
        CloseableHttpClient httpClient = getHttpClient();
        StringBuilder param = new StringBuilder("?");
        if (paramMap != null) {
            for(Map.Entry<String, String> entry: paramMap.entrySet()) {
                param.append(entry.getKey());
                param.append("=");
                param.append(entry.getValue());
                param.append("&");
            }
            param.deleteCharAt(param.length() - 1);
        }

        HttpGet get = new HttpGet(requestUrl + param);
        String responseString = httpClient.execute(get, response -> EntityUtils.toString(response.getEntity()));
        get.releaseConnection();
        return responseString;
    }

    //Post 文件

    public  static  String doPostFile(String url,Map<String, String> paramMap,String localFileName) throws  IOException{

        byte[] res            = doPostByFile(url,paramMap,localFileName);
        return new String(res);

    }

    /**postfile个服务器 */
    public  static  byte[]  doPostByFile(String url,Map<String, String> paramMap,String localFileName) throws  IOException{


        CloseableHttpClient httpClient = getHttpClient();

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        for (String s: paramMap.keySet()
        ) {
            httpPost.setHeader(s,paramMap.get(s));
        }

        MultipartEntityBuilder  builder = MultipartEntityBuilder.create();
        String fileName = localFileName ;
        File f = new File(fileName);
        builder.addBinaryBody(
                "binFile",
                new FileInputStream(f),
                ContentType.APPLICATION_OCTET_STREAM,
                f.getName()
        );

        builder.addTextBody("Language", "9");  //添加文本类型参数
        httpPost.setEntity(builder.build());
        HttpResponse response = httpClient.execute(httpPost);
        byte[] res            = null;
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            res = EntityUtils.toByteArray(response.getEntity());
        }

        return res;
        //return new String(res);


    }

    //post 表单数据
    public static String doPost(String requestUrl, Map<String, String> paramMap) throws IOException {

        CloseableHttpClient httpClient = getHttpClient();
        List<NameValuePair> lstParam = new ArrayList<NameValuePair>();

        if (paramMap != null) {
            for(Map.Entry<String, String> entry: paramMap.entrySet()) {
                lstParam.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        HttpPost post = new HttpPost(requestUrl );
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(lstParam,"utf-8");
        post.setEntity(urlEncodedFormEntity);
        String responseString = httpClient.execute(post, response -> EntityUtils.toString(response.getEntity()));
        post.releaseConnection();
        return responseString;

    }



    /** post json */
    public  static  String doPostJson(String requestUrl,String json){

        String body = null;
        HttpPost post = new HttpPost(requestUrl);
        if (post != null & json != null
                && !"".equals(json.trim())) {
            try {

                // 建立一个NameValuePair数组，用于存储欲传送的参数
                post.addHeader("Content-type","application/json; charset=utf-8");
                post.setHeader("Accept", "application/json");
                post.setEntity(new StringEntity(json, Charset.forName("UTF-8")));
                HttpResponse response = httpClient.execute(post);
                body = EntityUtils.toString(response.getEntity());

            } catch (IOException e) {

                return  "";

            } finally {
                post.releaseConnection();
            }

        }
        return body;



    }

    public static String getHeader(String name) {
        HttpServletRequest request = getHttpServletRequest();
        if (request != null) {
            return  request.getHeader(name) != null ? request.getHeader(name) : request.getParameter(name);
        }
        return null;
    }

    public static HttpServletRequest getHttpServletRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        if (null != requestAttributes) {
            return requestAttributes.getRequest();
        }
        return null;
    }

    public static String getParameterValue(String name) {
        HttpServletRequest request = getHttpServletRequest();
        if (request != null) {
            return request.getParameter(name);
        }
        return null;
    }
}

