package com.gaohj.springdemo.service;

import com.gaohj.springdemo.utils.HttpClientUtils;

public class MsgService {

    private  String url;
    private String keyId;
    private String secret;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public MsgService(String url, String keyId, String secret) {
        this.url = url;
        this.keyId = keyId;
        this.secret = secret;
    }

    public void sendMsg(String msg){
        HttpClientUtils.sendMsg(url, keyId, secret, msg);
    }
}
