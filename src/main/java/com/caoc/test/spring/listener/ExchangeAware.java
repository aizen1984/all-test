package com.caoc.test.spring.listener;


import java.util.function.BooleanSupplier;

/**
 * @author caochen
 */
@FunctionalInterface
public interface ExchangeAware extends BooleanSupplier {

	String getExchange();

	default String getRouteKey() {
		return null;
	}

	@Override
	default boolean getAsBoolean() {
		return true;
	}

}
