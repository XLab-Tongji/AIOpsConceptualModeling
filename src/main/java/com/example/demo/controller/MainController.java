package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.*;
import com.example.demo.model.*;

import java.io.FileNotFoundException;

/**
 * @author Raven
 */
@RestController
@RequestMapping("/ont")
public class MainController {
    /**
     * 初始化OWL文件
     */
    public String owlInitialize(String layer) throws FileNotFoundException {
        OntService ontService = new OntService(layer);
        YamlService yamlService = new YamlService(layer);
        AbstractModel baseOnt = new AbstractModel();
        baseOnt.setClasses(yamlService.YamlToProps().getClasses());
        baseOnt.setRelations(yamlService.YamlToProps().getRelations());
        ontService.ontInit(baseOnt);
        return "Owl initialized";
    }
    /**
     * 分层进行模型构建
     */

    /**
     * datamodel层
     */
    @RequestMapping("/dataModel")
    public void dataModel() throws FileNotFoundException {
        String layer = "DataModel";
        owlInitialize(layer);
    }

    /**
     * API层
     */
    @RequestMapping("/API")
    public void API() throws FileNotFoundException {
        String layer = "API";
        owlInitialize(layer);
    }

    /**
     * SDK
     * @throws FileNotFoundException
     */
    @RequestMapping("/SDK")
    public void SDK() throws FileNotFoundException {
        String layer = "SDK";
        owlInitialize(layer);
    }

    /**
     * 真实数据
     * @throws FileNotFoundException
     */
    @RequestMapping("/ViewModel")
    public void ViewModel() throws FileNotFoundException {
        String layer = "ViewModel";
    }


}
