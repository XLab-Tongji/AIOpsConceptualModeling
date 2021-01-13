package com.example.demo.model;

import lombok.Data;

/**
 * @author WuYue
 * This class construct a triple for modeling purpose
 */
@Data
public class Triple<A,B,C> {
    public A first;
    public B second;
    public C third;
}
