package com.example.demo.model;

import lombok.Data;

/**
 * @author WuYue
 */
@Data
public class Triple<A,B,C> {
    public A first;
    public B second;
    public C third;
}
