package com.example.demo;

import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Raven
 */
public class PrometheusGet {
    public static void main(String[] args){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://10.60.38.174:31003/api/v1/query?query={query}";
        String user = "admin";
        String pwd = "admin";
        String query = "sum(node_disk_io_now) by ()";
        String query2 = "topk(5, max(scrape_duration_seconds) by (job))";
        String query3 = "sum by (statuscode) (irate(http_request_total{job='grafana'}[5m]))";

        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(user, pwd));

        HttpHeaders headers = new HttpHeaders();

        Map<String, Object> paramMap = new HashMap<>(10);
        paramMap.put("query", query);

        HttpEntity<String> ans = restTemplate
                .exchange(url, HttpMethod.GET, new HttpEntity<>(null, headers),
                        String.class, paramMap);

        String out = ans.getBody();

        System.out.println(ans);
    }
}
