package com.example.demo.service;

import netscape.javascript.JSObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xjt
 */

public class JaegerService {
    public Object tracesGet(String url, String user, String pwd,String traceId){
        RestTemplate restTemplate = new RestTemplate();
        //认证
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(user, pwd));
        HttpHeaders headers = new HttpHeaders();

        //String urll = url+traceId;
        //System.out.println(urll);
        //请求参数的列表
        Map<String, Object> paramMap = new HashMap<>(10);
        paramMap.put("traceId", traceId);

        //拼接字符串传参

        HttpEntity<String> ans = restTemplate
                .exchange(url,HttpMethod.GET,new HttpEntity<>(null, headers),
                        String.class, paramMap);

        return ans;
    }
}
