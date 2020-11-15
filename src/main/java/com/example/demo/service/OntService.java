package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.model.*;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

/**
 * @author WuYue
 */
public class OntService {
    OntDao ontDao = new OntDao();
    public void ontInit(AbstractModel baseOnt) throws FileNotFoundException {
        Map<String, Set<Triple<Object, String, Object>>> ontClasses=baseOnt.getClasses();
        Map<String, Set<Tuple<Object, Object>>> ontRelations=baseOnt.getRelations();

        for(Map.Entry<String, Set<Triple<Object, String, Object>>> entry : ontClasses.entrySet()){
            String newClass = entry.getKey();
            Set<Triple<Object, String, Object>> props = entry.getValue();
            ontDao.createClass(newClass);
            for(Triple<Object, String, Object> prop:props){
                Object propName=prop.first;
                String pN = propName.toString();
                Object propDesc=prop.third;
                String pD = propDesc.toString();
                String type=prop.second;
                ontDao.addDataProp(newClass, pN, type, pD);
            }
        }

        for(Map.Entry<String, Set<Tuple<Object, Object>>> entry : ontRelations.entrySet()){
            Set<Tuple<Object, Object>> tuples= entry.getValue();
            String domain = null;
            String range = null;
            String relation = null;
            for(Tuple<Object, Object> tuple:tuples){
                String type=tuple.getFirst().toString();
                Object value=tuple.getSecond();
                switch (type){
                    case "relation":
                        relation=value.toString();
                        break;
                    case "domain":
                        domain=value.toString();
                        break;
                    case "range":
                        range=value.toString();
                        break;
                }
            }
            ontDao.optProp(relation,domain,range);

        }
    }
}
