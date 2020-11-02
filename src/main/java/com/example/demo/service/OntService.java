package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.model.*;

import java.io.FileNotFoundException;
import java.util.Map;

/**
 * @author Raven
 */
public class OntService {
    OntDao ontDao = new OntDao();
    public void ontInit(OntModel baseOnt) throws FileNotFoundException {
        String mark = baseOnt.getId();
        Map<String, String> ontClassRelation = baseOnt.getOntClassRelation();
        Map<String, String> ontProp = baseOnt.getOntProp();
        Map<String, String> ontPropRelation = baseOnt.getOntPropRelation();

        for(Map.Entry<String, String> entry : ontClassRelation.entrySet()){
            String childClass = entry.getKey();
            String parentClass = entry.getValue();
            ontDao.createClass(childClass, parentClass);
        }

        for(Map.Entry<String, String> entry : ontProp.entrySet()){
            String child = entry.getKey();
            String value = entry.getValue();
            String parent = ontPropRelation.get(child);
            ontDao.addProp(child, parent, value);
        }
    }
}
