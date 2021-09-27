package com.rules.model;

import lombok.Data;

@Data
public class Car {
    private Integer discount = 100;
    private Person person;
}
