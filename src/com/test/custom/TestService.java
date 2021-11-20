package com.test.custom;


public class TestService {

    public String testPrint(String name) {
        String result = name + "调用当前方法";
        System.out.println(name + "调用当前方法");
        return result;
    }
}
