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
     * Map classes describes class name and a set of its properties,datatype of which and description.
     * Map relations describes relation identification and a set of its descriptions like Domain : domain,
     * Relation : relation name,Range : range.
     */
    private Map<String, Set<Triple<Object, Object, Object>>> classes;
    private Map<String, Set<Tuple<Object, Object>>> relations;
}
