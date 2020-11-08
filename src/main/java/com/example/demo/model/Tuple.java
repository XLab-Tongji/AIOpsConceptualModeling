package com.example.demo.model;

import lombok.Data;

/**
 * @author Raven
 */
@Data
public class Tuple<A, B> {
    public A first;
    public B second;
}
