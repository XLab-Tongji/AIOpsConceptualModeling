package com.example.demo.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raven
 */
public class PromService {
    //从Prometheus中获取metrics数据
    public void metricsGet(String url, String user, String pwd, String query){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(user, pwd));

        HttpHeaders headers = new HttpHeaders();

        Map<String, Object> paramMap = new HashMap<>(10);
        paramMap.put("query", query);

        HttpEntity<String> ans = restTemplate
                .exchange(url, HttpMethod.GET, new HttpEntity<>(null, headers),
                        String.class, paramMap);

        System.out.println(ans);
    }
}
