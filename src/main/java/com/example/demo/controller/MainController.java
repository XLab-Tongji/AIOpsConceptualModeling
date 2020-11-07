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
    @RequestMapping("/owl")
    public String owlInitialize() throws FileNotFoundException {
        OntModel baseOnt = new OntModel();
        ontService.ontInit(baseOnt);
        return "Owl initialized";
    }
}
