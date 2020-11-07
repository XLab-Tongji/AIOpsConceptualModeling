package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.model.*;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

/**
 * @author Raven
 */
public class OntService {
    OntDao ontDao = new OntDao();
    public void ontInit(AbstractModel baseOnt) throws FileNotFoundException {
        Map<String, Set<Tuple<String, String>>> ontClasses=baseOnt.getClasses();
        Map<String, Triple<String, String, String>> ontRelations=baseOnt.getRelations();

        for(Map.Entry<String, Set<Tuple<String, String>>> entry : ontClasses.entrySet()){
            String newClass = entry.getKey();
            Set<Tuple<String, String>> props = entry.getValue();
            ontDao.createClass(newClass);
            for(Tuple<String,String>prop:props){
                String propName=prop.first;
                String propDesc=prop.second;
                ontDao.addProp(propName,newClass,propDesc);
            }
        }

        for(Map.Entry<String, Triple<String, String, String>> entry : ontRelations.entrySet()){
            Triple<String,String,String> triple= entry.getValue();
            String class1=triple.first;
            String class2=triple.third;
            String relation=triple.second;
            ontDao.optProp(relation,class1,class2);
        }
    }
}
