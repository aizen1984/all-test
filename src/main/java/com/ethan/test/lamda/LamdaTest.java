package com.ethan.test.lamda;


import com.ethan.test.lamda.steam.Dish;
import com.ethan.test.lamda.steam.Dish2;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class LamdaTest {

    public static void main(String[] args) throws IOException {
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
//        System.out.println(transactions.stream().filter(x -> x.getYear() > 2011)
//                .sorted((t1, t2) -> t2.getValue() - t1.getValue()
//                ).collect(Collectors.toList()));
//        //交易员在哪些不同的城市工作过
//        System.out.println(transactions.stream()
//                .map(x -> x.getTrader().getCity()).distinct().collect(Collectors.toList()));
//
//        //查找所有来自剑桥的交易员，并按姓名排序
//        System.out.println(transactions.stream().filter(x -> x.getTrader().getCity().equals("Cambridge"))
//                .sorted(Comparator.comparing(t -> t.getTrader().getName())).collect(Collectors.toList()));

        //返回所有交易员的姓名字符串，并按字母顺序排序


        //有没有交易员在米兰工作的？

        //打印生活在剑桥的交易员的所有交易额

        //所有交易中，最高的交易额是多少

        //找到交易额最小的交易

//        ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(() -> DateFormat.getDateTimeInstance());
//        System.out.println(threadLocal.get().format(new Date()));
//        System.out.println(check(6, x -> x > 5));
//
//        LocalDate startDate = LocalDate.of(2019, 9, 9);
//        LocalDate endDate = LocalDate.of(2019, 12, 31);
//
//        long diff = ChronoUnit.DAYS.between(startDate, endDate);
//        //System.out.println((diff / 365));
//        System.out.println(new BigDecimal(diff).divide(new BigDecimal(365), 3,
//                BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(10)));

//        System.out.println("===");
//        transactions.stream().filter(x -> {
//            System.out.println(x);
//            return x.getYear() == 2012;
//        }).count();

//        System.out.println(
//                Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).map(n -> n.stream()).collect(Collectors.toList())
//        );
//
//        System.out.println(
//                Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).flatMap(n -> n.stream()).collect(Collectors.toList())
//        );

//        Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).map(n -> n.stream()).collect(Collectors.toList())
//                .forEach(x -> x.forEach(t -> {
//                    System.out.print(t);
//                }));


//        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::sum).get());

//        System.out.println(transactions.stream().flatMap(x -> Stream.of(x.getTrader(), x.getValue())).collect(Collectors.toList()));


//        String s = "abcd";
//        System.out.println(s.charAt(0));

//        String onLine = processFile(br -> br.readLine());


        //flatMap
//        String[] arrays = new String[]{"hello", "world"};
//        Stream<String> stringStream = Arrays.stream(arrays);
//        System.out.println(stringStream.map(x -> x.split("")).
//                flatMap(x -> Arrays.stream(x)).distinct().collect(Collectors.toList()));

//        List<Integer> num1 = Arrays.asList(1, 2, 3);
//        List<Integer> num2 = Arrays.asList(3, 4);
//
//        List<int[]> pairs = num1.stream().flatMap(x -> num2.stream().map(y -> new int[]{x, y})).collect(Collectors.toList());
//        pairs.stream().forEach(x -> System.out.print(Arrays.toString(x)));
//        System.out.println(Arrays.toString(new int[]{1, 2}));
//
//        num2.stream().allMatch(x -> x == 1);
//        num1.stream().anyMatch(x -> x == 2);
//        num1.stream().noneMatch(x -> x == 3);
//        CollectionUtils.isEmpty(num1);
//        CollectionUtils.isEmpty(new HashMap<>());
//        num1.stream().findAny().orElse(1);
//        //map-reduce 模式
//        num1.stream().map(x -> 1).distinct().reduce(0, Integer::sum);
//        num1.stream().min(Comparator.comparing(x -> x));
//        num1.stream().mapToInt(x -> x).max();
//
//        IntStream.rangeClosed(1, 10).forEach(System.out::print);
//        System.out.println();
//        IntStream.rangeClosed(1, 100).boxed().flatMap(a ->
//                IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
//                        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));
//
//        System.out.println(IntStream.rangeClosed(1, 100).boxed().getClass());


        List<Dish> menu = Arrays.asList(
                new Dish(null, false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));


        long howManyDish = menu.stream().collect(Collectors.counting());
        System.out.println("howManyDish->" + howManyDish);

        long howManyDish2 = menu.stream().count();
        System.out.println("howManyDish2->" + howManyDish);

        Comparator<Dish> dishComparator = comparing(Dish::getCalories);
        //Comparator<Dish> dishComparator1 = (o1, o2) -> o1.getCalories() - o2.getCalories();

        Optional<Dish> optionalDish = menu.stream().collect(Collectors.maxBy(dishComparator));
        System.out.println(optionalDish.orElse(new Dish()));

        Optional<Integer> optionalDishCalories = menu.stream()
                .collect(Collectors.maxBy(dishComparator)).map(x -> x.getCalories());
        System.out.println(optionalDishCalories.orElse(0));

        IntSummaryStatistics menusIntSummaryStatistics =
                menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(menusIntSummaryStatistics);


        //可以 join
        System.out.println(menu.stream().map(Dish::getName).
                filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(",")));

        System.out.println(menu.stream().map(Dish::getCalories).reduce(0, (x, y) -> x + y));
        System.out.println(menu.stream().filter(t -> t.getCalories() > 0).
                collect(Collectors.reducing(0, Dish::getCalories, Integer::sum)));

        Map<Dish.Type, List<Dish>> typeListMap = menu.stream().collect(Collectors.groupingBy(Dish::getType));
        System.out.println(typeListMap);

        Map<String, List<Dish>> typeListMap2 = menu.stream().
                collect(Collectors.groupingBy(t -> {
                    if (t.getCalories() > 700) {
                        return "high";
                    } else {
                        return "low";
                    }
                }));

        System.out.println(typeListMap2);

        Map<Dish.Type, Map<String, List<Dish>>> typeListMap3 = menu.stream()
                .collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(t -> {
                    if (t.getCalories() > 700) {
                        return "high";
                    } else {
                        return "low";
                    }
                })));

        Map<Dish.Type, Long> typeLongMap = menu.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.counting()));

        Map<Dish.Type, Optional<Dish>> typeOptionalMap = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(comparingInt(Dish::getCalories))));

        System.out.println(typeOptionalMap);


        Map<Dish.Type, Dish> typeDishMap = menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));

        System.out.println(typeDishMap);

        System.out.println(menu.stream().map(t -> {
            Dish2 dish2 = new Dish2();
            dish2.setCalories(t.getCalories());
            dish2.setName("2" + t.getName());
            return dish2;
        }).collect(Collectors.toList()));

//        System.out.println(DoubleStream.iterate(1L,n->n+1).limit(12).reduce(1.1,(a,b)->a*b));
//        Double aDouble = DoubleStream.iterate(1L, n -> n + 1).limit(12).reduce(1, (a, b) -> {
//            System.out.print("a->" + a);
//            System.out.print(" b->" + b);
//            double result = a * 1.1;
//            System.out.println(" a*b->" + result);
//            return result;
//        });
//        System.out.println("aDouble-->" + aDouble);
//
//        double i = 1;
//        for (double j = 1; j <= 12; j++) {
//            System.out.print("j-->"+j);
//            i = i * 1.1;
//            System.out.println(" i-->"+ i);
//        }
//        System.out.println(i);


        //test
    }

    private static boolean check(Integer t, Predicate<Integer> predicate) {
        return predicate.test(t);
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


    public static String processFile(BufferedReadProcesser bufferedReadProcesser) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));
        return bufferedReadProcesser.process(bufferedReader);
    }


}
