package com.migu.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class caseTools {
/**
 * @Author: liyang
 * @return: 接口调用地址getBookItemUrl
 */
    public static String getMethodUrl(String methodName){
        //获取当前运行的环境
        ResourceBundle bundle = ResourceBundle.getBundle("env", Locale.CHINA);
        String env = bundle.getString("CONTENT-SERVICES-ENV");
        //根据当前环境去切换对应的接口调用地址
        String url = environmentChange.environmentUrl(env,methodName);
        //拼接接口请求地址
        return url;
    }

    /**
     * @Author: liyang
     * @return: 接口调用地址getBookItemUrl
     */
    public static String getContentType(String type){
        String DefaultContentType = "application/json";
        //获取当前运行的环境
        if(type.equals("json")|| type.equals("JSON")) {
            return "application/json";
        }else if(type.equals("xml")|| type.equals("XML")){
            return "application/xml";
        }else{
            return DefaultContentType;
        }
    }

}
