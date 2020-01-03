package com.caoc.test.java8date;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author caochen
 */
public class DateTest {
	public static void main(String[] args) {
		LocalDate endDate = LocalDate.now();
		DayOfWeek dayOfWeek = endDate.getDayOfWeek();
		System.out.println(dayOfWeek.getValue());
		System.out.println(getWeekOfDate(new Date()));


		LocalDate startDate = LocalDate.of(2019, 9, 11);
		System.out.println(startDate.until(endDate, ChronoUnit.DAYS));

		System.out.println(new BigDecimal(110).setScale(2, BigDecimal.ROUND_HALF_DOWN)
				.divide(new BigDecimal(365)
						.setScale(2, BigDecimal.ROUND_HALF_DOWN), 2, BigDecimal.ROUND_HALF_DOWN)
				.multiply(new BigDecimal(10)));


	}


	public static String getWeekOfDate(Date dt) {
		String[] weekDays = {"7", "1", "2", "3", "4", "5", "6"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);

		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
		}
		return weekDays[w];
	}
}
