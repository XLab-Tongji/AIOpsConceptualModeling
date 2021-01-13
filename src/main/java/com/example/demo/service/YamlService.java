package com.example.demo.service;
import com.example.demo.dao.YamlDao;

import java.io.FileNotFoundException;
import java.security.PublicKey;
import java.util.*;

import com.example.demo.model.*;
/**
 * @author xjt
 */
public class YamlService {

    public String layer;
    public YamlService(String Layer) {
        this.layer = Layer;
    }
    AbstractModel primeModel = new AbstractModel();

    //读取yaml文件，将yaml模型转化为java模型
    public AbstractModel YamlToProps() throws FileNotFoundException {

        String path = layer+".yml";
        YamlDao myYaml = new YamlDao(path);
        AbstractModel primeModel = new AbstractModel();
        Map<String,Set<Tuple<Object,Object>>> myRelations=  myYaml.yamlToRelations();
        Map<String, Set<Triple<Object,String,Object>>> myProps = myYaml.yamlToClass();
        primeModel.setClasses(myProps);
        primeModel.setRelations(myRelations);
        OntService ontService = new OntService(this.layer);
        ontService.ontInit(primeModel);
        return primeModel;
    }

}
