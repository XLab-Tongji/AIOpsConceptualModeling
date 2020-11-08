package com.example.demo.controller;

import com.example.demo.dao.YamlDao;
import com.github.jsonldjava.utils.Obj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.*;
import com.example.demo.model.*;

import java.io.FileNotFoundException;
import java.util.*;


/**
 * @author xjt
 */
@RestController
@RequestMapping("/yaml")
public class YamlController {
    OntService ontService = new OntService();
    YamlDao myyaml = new YamlDao("overview 11.8.yml");

    AbstractModel primeModel = new AbstractModel();
    @RequestMapping("/init")
    public AbstractModel YamlToProps() throws FileNotFoundException {

        Map<String,Triple<String,String,String>> myRelations=  myyaml.yamlToRelations();
        Map<String, Set<Tuple<String,String>>> myProps = myyaml.yamlToClass();
        primeModel.setClasses(myProps);
        primeModel.setRelations(myRelations);
        OntService ontService = new OntService();
        ontService.ontInit(primeModel);
        return primeModel;

    }
}
