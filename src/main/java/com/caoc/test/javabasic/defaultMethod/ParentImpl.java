package com.caoc.test.javabasic.defaultMethod;

public class ParentImpl implements Parent {
    @Override
    public void message(String body) {
        System.out.println(body);
    }

    @Override
    public String getLastMessage() {
        return null;
    }
}
