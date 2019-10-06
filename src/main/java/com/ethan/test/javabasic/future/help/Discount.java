package com.ethan.test.javabasic.future.help;

import com.ethan.test.javabasic.future.ShopCompletableFuture;

public class Discount {
	public enum Code {
		NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
		private final int percentage;

		Code(int percentage) {
			this.percentage = percentage;
		}
	}

	public static String apply(double price, Code code) {
		ShopCompletableFuture.delay();
		return String.valueOf(price * (100 - code.percentage) / 100);

	}

	public static String applyDiscount(Quote quote) {
		return quote.getShopName() + ": price is :" +
				Discount.apply(quote.getPrice(),
						quote.getDiscountCode());
	}
}
