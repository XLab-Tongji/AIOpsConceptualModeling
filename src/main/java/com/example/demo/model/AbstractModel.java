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
    private Map<String, Set<Tuple<String, String>>> relations;
}
