package com.rules.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ListMapFact {

    private List<Person> personList;

    private Map<String, Integer> personListMap;

}
