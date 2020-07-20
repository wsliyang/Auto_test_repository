package com.migu.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class environmentChange {
    private static String getBookItemUrl = null;
    public static String environmentUrl(String env,String methodName){

        if(env.equals("st")|| env.equals("ST")){
            ResourceBundle bundle = ResourceBundle.getBundle("request_url_st", Locale.CHINA);
            String url = bundle.getString("CONTENT-SERVICES-ADDR");
            //拼接接口请求地址
            getBookItemUrl = url + methodName;
        }else if(env.equals("sit") || env.equals("SIT")){
            ResourceBundle bundle = ResourceBundle.getBundle("request_url_sit", Locale.CHINA);
            String url = bundle.getString("CONTENT-SERVICES-ADDR");
            //拼接接口请求地址
            getBookItemUrl = url + methodName;
        }else{
            return "";
        }
        return getBookItemUrl;
    }
}
