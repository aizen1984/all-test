package com.ethan.test.lamda.steam;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

//@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Dish {

	private String name;
	private boolean vegetarian;
	private int calories;
	private Type type;
	//名义综合年化成本
	private BigDecimal nameAnnualFeeRate;
	//实际综合年化成本
	private BigDecimal realAnnualFeeRate;

//	public Dish() {
//		this.name = "name";
//		this.vegetarian = false;
//		this.calories = 0;
//		this.type = Type.OTHER;
//
//	}
//
//
//	public Dish(){
//
//	}

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}


	public enum Type {
		MEAT, FISH, OTHER
	}




}
