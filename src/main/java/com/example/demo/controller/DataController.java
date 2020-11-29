package com.example.demo.controller;

import com.example.demo.service.PromService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Raven
 */
@RestController
@RequestMapping("/data")
public class DataController {
    PromService promService = new PromService();
    @RequestMapping("/metrics")
    public void getData(){
        String url = "http://10.60.38.174:31003/api/v1/query?query={query}";
        String user = "admin";
        String pwd = "admin";
        String query = "sum(node_disk_io_now) by ()";
        promService.metricsGet(url, user, pwd, query);
    }

}
