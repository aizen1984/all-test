package com.caoc.test.javabasic.defaultMethod;

public interface Parent {

    void message(String body);

    default void welcome() {
        message("parent,hi");
    }

    String getLastMessage();

}
