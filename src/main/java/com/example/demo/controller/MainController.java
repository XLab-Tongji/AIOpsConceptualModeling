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
    public String owlInitialize(String layer) throws FileNotFoundException {
        OntService ontService = new OntService(layer);
        YamlService yamlService = new YamlService(layer);
        AbstractModel baseOnt = new AbstractModel();
        baseOnt.setClasses(yamlService.YamlToProps().getClasses());
        baseOnt.setRelations(yamlService.YamlToProps().getRelations());
        ontService.ontInit(baseOnt);
        return "Owl initialized";
    }
    @RequestMapping("/dataModel")
    public void dataModel() throws FileNotFoundException {
        String layer = "DataModel";
        owlInitialize(layer);
    }
    @RequestMapping("/API")
    public void API() throws FileNotFoundException {
        String layer = "API";
        owlInitialize(layer);
    }
    @RequestMapping("/SDK")
    public void SDK() throws FileNotFoundException {
        String layer = "SDK";
        owlInitialize(layer);
    }


}
