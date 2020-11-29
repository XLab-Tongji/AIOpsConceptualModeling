package com.example.demo.service;
import com.example.demo.dao.YamlDao;

import java.io.FileNotFoundException;
import java.util.*;

import com.example.demo.model.*;
/**
 * @author xjt
 */
public class YamlService {
    OntService ontService = new OntService("test");
    YamlDao myyaml = new YamlDao("API 11.17.yml");

    AbstractModel primeModel = new AbstractModel();
    public AbstractModel YamlToProps() throws FileNotFoundException {

        Map<String,Set<Tuple<Object,Object>>> myRelations=  myyaml.yamlToRelations();
        Map<String, Set<Triple<Object,String,Object>>> myProps = myyaml.yamlToClass();
        primeModel.setClasses(myProps);
        primeModel.setRelations(myRelations);
        OntService ontService = new OntService("test");
        ontService.ontInit(primeModel);
        return primeModel;
    }

}
