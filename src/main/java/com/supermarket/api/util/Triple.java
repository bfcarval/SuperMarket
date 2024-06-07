package com.supermarket.api.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class Triple<T, U, V> {

    private T first;
    private U second;
    private V third;
}