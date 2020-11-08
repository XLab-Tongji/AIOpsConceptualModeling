package com.example.demo.model;

import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * @author Raven
 */
@Data
public class AbstractModel {
    /**
     * Map classes describes class name and a set of its properties and datatype of which.
     * Map relations describes relation name and a set of its domains and ranges.
     */
    private Map<String, Set<Tuple<String, String>>> classes;
    private Map<String, Triple<String, String, String>> relations;
    public Map<String, Set<Tuple<String, String>>> getClasses(){
        return classes;
    }
    public Map<String, Triple<String, String, String>> getRelations(){
        return relations;
    }

}
