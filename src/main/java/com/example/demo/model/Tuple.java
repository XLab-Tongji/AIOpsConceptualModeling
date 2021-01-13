package com.example.demo.model;

import lombok.Data;

/**
 * @author Raven
 * This class construct a tuple for modeling purpose
 */
@Data
public class Tuple<A, B> {
    public A first;
    public B second;
}
