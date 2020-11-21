package com.gaohj.springdemo.utils;

/**
 * 短信发送
 */
public class HttpClientUtils {

    public static  int sendMsg(String url, String keyId, String secret, String msg){
        System.out.println("短信发送:" + url + keyId + secret + msg);
        return  0;
    }
}
