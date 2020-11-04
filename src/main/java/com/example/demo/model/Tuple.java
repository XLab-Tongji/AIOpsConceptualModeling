package com.example.demo.model;

import lombok.Data;

/**
 * @author Raven
 */
@Data
public class Tuple<A, B> {
    public final A first;
    public final B second;
}
