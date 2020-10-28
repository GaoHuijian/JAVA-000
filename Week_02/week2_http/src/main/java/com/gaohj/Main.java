package com.gaohj;


/**
 * @author gaohj
 * 简单http调用
 */
public class Main {

    public final static  String url = "http://localhost:8088";

    public static void main(String[] args) throws  Exception{
        String result = HttpClientUtil.getInstance().sendHttpGet(url);
        System.out.println(result);
    }

}
