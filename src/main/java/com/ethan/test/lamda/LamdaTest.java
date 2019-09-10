package com.ethan.test.lamda;

import java.util.*;
import java.util.stream.Collectors;

public class LamdaTest {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        //找出2011年发生的所有交易，并按交易额排序
        System.out.println(transactions.stream().filter(x -> x.getYear() > 2011)
                .sorted((t1, t2) -> t2.getValue() - t1.getValue()
                ).collect(Collectors.toList()));
        //交易员在哪些不同的城市工作过
        System.out.println(transactions.stream()
                .map(x -> x.getTrader().getCity()).distinct().collect(Collectors.toList()));

        //查找所有来自剑桥的交易员，并按姓名排序
        System.out.println(transactions.stream().filter(x -> x.getTrader().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(t -> t.getTrader().getName())).collect(Collectors.toList()));

        //返回所有交易员的姓名字符串，并按字母顺序排序


        //有没有交易员在米兰工作的？

        //打印生活在剑桥的交易员的所有交易额

        //所有交易中，最高的交易额是多少

        //找到交易额最小的交易


    }


    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
