package com.example.demo.service;
import com.example.demo.dao.YamlDao;

import java.io.FileNotFoundException;
import java.util.*;

import com.example.demo.model.*;
/**
 * @author xjt
 */
public class YamlService {
    private String layer;
    YamlDao myyaml;
    public YamlService(String layer) {
        this.layer = layer;
        if(layer.equals("API")){myyaml=new YamlDao("API 11.17.yml");}
        else if(layer.equals("SDK")){myyaml=new YamlDao("SDK 12.8.yml");}
        else{myyaml=new YamlDao("view model 12.15.yml");}
    }
    OntService ontService = new OntService(this.layer);

    AbstractModel primeModel = new AbstractModel();

    public AbstractModel YamlToProps() throws FileNotFoundException {

        Map<String,Set<Tuple<Object,Object>>> myRelations=  myyaml.yamlToRelations();
        Map<String, Set<Triple<Object,String,Object>>> myProps = myyaml.yamlToClass();
        primeModel.setClasses(myProps);
        primeModel.setRelations(myRelations);
        OntService ontService = new OntService(this.layer);
        ontService.ontInit(primeModel);
        return primeModel;
    }

}
