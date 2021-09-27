package com.rules.service.impl;

import com.rules.service.TestService;

public class TestServiceImpl implements TestService {

    public static void test1(String param) {
        System.out.println("TestServiceImpl.test1 executed, param: " + param);
    }

    @Override
    public String test2(String param) {
        System.out.println("TestServiceImpl.test2 executed, param: " + param);
        return param;
    }

}
