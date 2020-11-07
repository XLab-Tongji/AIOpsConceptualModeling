package com.example.demo.model;

import lombok.Data;

import java.util.Map;

/**
 * @author Raven
 */
@Data
public class RelationModel {
    private Map<String, Tuple<String, String>> relation;
}
