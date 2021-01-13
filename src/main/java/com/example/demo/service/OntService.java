package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

/**
 * @author WuYue
 */
public class OntService {
    private String layer;
    public OntService(String layer) {
        this.layer = layer;
    }
    public void ontInit(AbstractModel baseOnt) throws FileNotFoundException {
        OntDao ontDao = new OntDao(layer);
        //用于储存java模型，分为类和关系储存
        Map<String, Set<Triple<Object, String, Object>>> ontClasses=baseOnt.getClasses();
        Map<String, Set<Tuple<Object, Object>>> ontRelations=baseOnt.getRelations();

        //向本题中添加类和属性
        for(Map.Entry<String, Set<Triple<Object, String, Object>>> entry : ontClasses.entrySet()){
            String newClass = entry.getKey();
            Set<Triple<Object, String, Object>> props = entry.getValue();
            ontDao.createClass(newClass);
            for(Triple<Object, String, Object> prop:props){
                //属性名称
                Object propName=prop.first;
                String pN = propName.toString();
                //对属性的描述
                Object propDesc=prop.third;
                String pD = propDesc.toString();
                //属性的类型
                String type=prop.second;
                ontDao.addDataProp(newClass, pN, type, pD);
            }
        }

        //向本体中添加类和类的关系
        for(Map.Entry<String, Set<Tuple<Object, Object>>> entry : ontRelations.entrySet()){
            Set<Tuple<Object, Object>> tuples= entry.getValue();
            String domain = null;
            String range = null;
            String relation = null;
            //获取关系的三元组：Domain、Range、关系名Name
            for(Tuple<Object, Object> tuple:tuples){
                String type=tuple.getFirst().toString();
                Object value=tuple.getSecond();
                switch (type){
                    case "Name":
                        relation=value.toString();
                        break;
                    case "Domain":
                        domain=value.toString();
                        break;
                    case "Range":
                        range=value.toString();
                        break;
                    default:break;
                }
            }
            ontDao.optProp(relation,domain,range);

        }
    }
}
