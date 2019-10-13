package com.caoc.test.javabasic.future.help;

public class Quote {
	private String shopName;
	private double price;
	private Discount.Code discountCode;

	public Quote(String shopName, double price, Discount.Code code) {
		this.shopName = shopName;
		this.price = price;
		this.discountCode = code;
	}

	public static Quote parse(String s) {
		String[] split = s.split(":");
		String shopName = split[0];
		double price = Double.parseDouble(split[1]);
		Discount.Code discountCode = Discount.Code.valueOf(split[2]);
		return new Quote(shopName, price, discountCode);
	}

	public String getShopName() { return shopName; }
	public double getPrice() { return price; }
	public Discount.Code getDiscountCode() { return discountCode; }





}
