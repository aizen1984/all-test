package com.caoc.test.lamda.test;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		test.aa();
	}

	private void aa() {
		Map<Integer, PeriodAmount> periodAmountMap = new HashMap<>();
		Map<Integer, PeriodAmount> periodAmountMap2 = new HashMap<>();

		Map<Integer, Map<Integer, PeriodAmount>> repayTypePeriodAmountMap = new HashMap<>();


		PeriodAmount periodAmount = new PeriodAmount();
		periodAmount.setPeriod(3);
		periodAmount.setMin(100);
		periodAmount.setMax(500);
		periodAmountMap.put(3, periodAmount);

		PeriodAmount periodAmount1 = new PeriodAmount();
		periodAmount1.setPeriod(6);
		periodAmount1.setMin(500);
		periodAmount1.setMax(1000);
		periodAmountMap.put(6, periodAmount1);

		PeriodAmount periodAmount2 = new PeriodAmount();
		periodAmount2.setPeriod(9);
		periodAmount2.setMin(1000);
		periodAmount2.setMax(1500);
		periodAmountMap2.put(9, periodAmount2);

		PeriodAmount periodAmount3 = new PeriodAmount();
		periodAmount3.setPeriod(12);
		periodAmount3.setMin(1500);
		periodAmount3.setMax(2500);


		periodAmountMap2.put(12, periodAmount3);

		repayTypePeriodAmountMap.put(1, periodAmountMap);
		repayTypePeriodAmountMap.put(2, periodAmountMap2);

//		repayTypePeriodAmountMap.values().stream().map(Map::values).forEach(periodAmounts -> {
//			periodAmounts.stream().forEach(p -> {
//				System.out.println(p.getPeriod() + "--" + p.getMin() + "---" + p.getMin());
//				System.out.println("------");
//			});
//		});

//		System.out.println("11111");
		//Map<Integer, Map<Integer, PeriodAmount>>
//		repayTypePeriodAmountMap.values().stream().map(Map::values)
//				.sorted((x,y)->{
//					System.out.println(x);
//					System.out.println(y);
//					return 1;
//				}).collect(Collectors.toList());


//		System.out.println(repayTypePeriodAmountMap.values().stream().flatMap(x->x.values().stream())
//				.min(Comparator.comparingInt(PeriodAmount::getMin)).get().getMin());
//
//		List<String> stages = new ArrayList<>();
//		stages.add("1");
//		stages.add("2");
//		stages.add("3");
//		stages.add("1");
//
//		List<PeriodAmount> list = new ArrayList<>();
//		list.add(periodAmount1);
//		list.add(periodAmount2);
//		list.add(periodAmount3);
//
//		list.stream().distinct().collect(Collectors.toList());
//
//		stages.stream().distinct().collect(Collectors.toList());
		List<String> list = new ArrayList<>();
		list.add("ZYB");
		System.out.println(JSON.toJSONString(list));

		Map<String, Boolean> map = new HashMap<>();
		map.put("userSafeProcessFlag", false);
		System.out.println(JSON.toJSONString(map));


	}


	public <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		Map<K, V> result = new LinkedHashMap<>();

		map.entrySet().stream()
				.sorted(Map.Entry.<K, V>comparingByValue()
						.reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		return result;
	}


}