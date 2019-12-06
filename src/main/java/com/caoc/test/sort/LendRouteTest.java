package com.caoc.test.sort;

import lombok.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LendRouteTest {

	public static List<AssertBankBo> assertBankBoList = new ArrayList<>();
	public static List<AssertBankBo> buBankBoList = new ArrayList<>();

	private static void init() {
		setValueToLisit(assertBankBoList);
		setValueToLisit(buBankBoList);
	}

	private static void setValueToLisit(List<AssertBankBo> list) {
		IntStream.range(0, 10).forEach(i -> {
			AssertBankBo assertBankBo = new AssertBankBo();
			assertBankBo.setAssertBank("assertBank" + i);
			assertBankBo.setAssertProductId("assertProductId" + i);
			assertBankBo.setMinLend(i % 2 == 0 ? 500 : 1000);
			assertBankBo.setMaxLend(new Random().nextInt(50000));
			assertBankBo.setOrder(new Random().nextInt(1000));
			list.add(assertBankBo);
		});
	}


	public static void main(String[] args) {
		init();
		List<AssertBankBo> sortedBankList = assertBankBoList.stream()
				.sorted(Comparator.comparingInt(AssertBankBo::getOrder))
				.collect(Collectors.toList());
		List<AssertBankBo> sortedBuList = buBankBoList.stream()
				.sorted(Comparator.comparingInt(AssertBankBo::getOrder))
				.collect(Collectors.toList());

		System.out.println(sortedBankList);
		System.out.println(sortedBuList);

		//剔除资方 暂时模拟
		//资方准入 以及 资金情况
		List<BankDetails> bankDetailsList = new ArrayList<>();

		//确定主排序 以还呗bu为主

		List<AssertBankBo> mainSort = null;
		mainSort = Optional.ofNullable(mainSort)
				.orElseThrow(() -> new IllegalArgumentException());

		//剔除 包括无资金的资方和客群禁止期数
		mainSort.stream().
				filter(t ->
						sortedBankList.stream().anyMatch(x -> x.getAssertBank().equals(t.getAssertBank())))
				.collect(Collectors.toList());

		//当天剩余额度、资方自支持的金额、分期、优惠券信息、卡支持情况


		//剔除资方


		//排序逻辑


		//匹配顾虑


	}


	/**
	 * 排序构造内部使用类
	 */
	@Setter
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	static class AssertBankBo {
		private String assertBank;
		private String assertProductId;
		private Integer minLend;
		private Integer maxLend;
		private Integer stage;
		private Integer order;

		@Override
		public String toString() {
			return this.assertBank + "-" + this.order;
		}
	}


	@Setter
	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	static class BankDetails {
		//剩余金额
		private Integer leftMoney;

	}

	static class DemoException extends Throwable {

		public DemoException() {
			super();
		}

		public DemoException(String message) {
			super(message);
		}


		@Override
		public String getMessage() {
			return "exception message";
		}
	}
}
