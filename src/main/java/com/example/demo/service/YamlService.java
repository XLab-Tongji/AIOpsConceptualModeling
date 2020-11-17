package com.example.demo.service;
import com.example.demo.dao.YamlDao;
import org.yaml.snakeyaml.*;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

import com.example.demo.model.*;
public class YamlService {
    OntService ontService = new OntService();
    YamlDao myyaml = new YamlDao("overview 11.8.yml");

    AbstractModel primeModel = new AbstractModel();
    public AbstractModel YamlToProps() throws FileNotFoundException {

        Map<String,Set<Tuple<Object,Object>>> myRelations=  myyaml.yamlToRelations();
        Map<String, Set<Triple<Object,String,Object>>> myProps = myyaml.yamlToClass();
        primeModel.setClasses(myProps);
        primeModel.setRelations(myRelations);
        OntService ontService = new OntService();
        ontService.ontInit(primeModel);
        return primeModel;
    }

}
