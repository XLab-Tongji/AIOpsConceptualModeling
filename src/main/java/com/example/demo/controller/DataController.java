package com.example.demo.controller;

import com.example.demo.service.JaegerService;
import com.example.demo.service.PromService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Raven
 */
@RestController
@RequestMapping("/data")
public class DataController {
    PromService promService = new PromService();
    JaegerService jaegerService = new JaegerService();

    /**
     * 从Prometheus中取metrics数据
     */
    @RequestMapping("/metrics")
    public void getData(){
        String url = "http://10.60.38.174:31003/api/v1/query?query={query}";
        String user = "admin";
        String pwd = "admin";
        String query = "sum(node_disk_io_now) by ()";
        promService.metricsGet(url, user, pwd, query);
    }
    /**
     * 从Jaeger中取trace数据
     */
    @RequestMapping("/traces/{traceId}")
    public Object getTraces(@PathVariable String traceId){
        String url = "http://10.60.38.174:31005/api/traces/{traceId}";
        String user = "admin";
        String pwd = "admin";

        /**
         * JSON 格式 需要通过Jackson转化成Java对象！
         */
        Object data = jaegerService.tracesGet(url, user, pwd, traceId);

        if(data instanceof Map) {
            System.out.println("ssssssss");
        }
        return data;
    }

}
