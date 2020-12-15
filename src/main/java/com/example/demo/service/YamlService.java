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
<<<<<<< HEAD
    public String layer;
    public YamlService(String Layer) {
        this.layer = Layer;
    }

=======
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
>>>>>>> 8be25662393388a102dfd3a80e3c5dd89830f002

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
