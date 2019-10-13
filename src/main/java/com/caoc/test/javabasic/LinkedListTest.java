package com.caoc.test.javabasic;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("1");
        linkedList.addFirst("2");
        linkedList.addLast("3");
        linkedList.addLast("4");
        System.out.println(linkedList);

    }
}
