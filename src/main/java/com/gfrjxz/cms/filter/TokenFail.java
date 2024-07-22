package com.gfrjxz.cms.filter;

public class TokenFail {

    /**
     * api 请求缺少token
     */
    public static final String NOTOKENHEADER = "{\"code\":100000,\"desc\":\"访问验证为空，请登录后再访问\"}";

    /**
     * 非法token
     */
    public static final String TOKENISILLEGAL = "{\"code\":100001,\"desc\":\"非法的验证，用户不存在或者没权限访问\"}";

    /**
     * token 过期
     */
    public static final String TOKENISEXPIRED = "{\"code\":100002,\"desc\":\"验证已过期,请登录后再访问\"}";


    public static final String NOACESS = "{\"code\":100003,\"desc\":\"无访问权限\"}";

    /**
     * 此处进行微站api 以及管理登录认证api接口地址的权鉴控制
     */
    public static final String[] IGNORE_URI = {""};

}
