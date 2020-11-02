package com.example.demo.model;

import lombok.Data;

import java.util.Map;

/**
 * @author Raven
 */
@Data
public class OntModel {
    private String id;
    private Map<String, String> ontClassRelation;
    private Map<String, String> ontPropRelation;
    private Map<String, String> ontProp;


    public OntModel(String id, Map<String, String> ontClassRelation, Map<String, String> ontPropRelation, Map<String, String> ontProp){
        this.id = id;
        this.ontClassRelation = ontClassRelation;
        this.ontPropRelation = ontPropRelation;
        this.ontProp = ontProp;
    }

    public OntModel() {

    }
}
