package com.ethan.test.transmit;

import java.util.HashMap;
import java.util.Map;

public class TransmitTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "heihei");
        map.put("hello2", "heihei2");
        transmit(map);
        System.out.println("outermap-->" + map);

        int i = 1;
        String s= "1";
        transmit2(i);
        transmit3(s);
        System.out.println(i);
        System.out.println(s);


    }

    public static void transmit(Map<String, Object> map) {
        Map<String, Object> map1 = new HashMap<>();
        map1.putAll(map);
        System.out.println(map1);
        map.clear();
        System.out.println("innermethod->" + map);
    }

    public static void transmit2(int i) {
        i = 999;
        System.out.println(i);
    }

    public static void transmit3(String s) {
        s = "999";
        System.out.println(s);
    }
}
