package com.example.demo.model;

import lombok.Data;

import java.util.Set;

/**
 * @author Raven
 */
@Data
public class ClassModel {
    private Set<String> className;
    private Set<String> propName;

    public ClassModel(){

    }
}
