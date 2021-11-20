package com.test.custom;


public class TestUser {

    private String name;

    public TestUser() {
    }

    public TestUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "========这是User测试文件2号========";
    }
}
