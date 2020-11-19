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
    OntService ontService = new OntService();
    YamlService yamlService = new YamlService();
    @RequestMapping("/owl")
    public String owlInitialize() throws FileNotFoundException {
        AbstractModel baseOnt = new AbstractModel();
        baseOnt.setClasses(yamlService.YamlToProps().getClasses());
        baseOnt.setRelations(yamlService.YamlToProps().getRelations());
        ontService.ontInit(baseOnt);
        return "Owl initialized";
    }
}
