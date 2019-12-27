package com.caoc.test.java8date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author caochen
 */
public class DateTest {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		System.out.println(dayOfWeek.getValue());
		System.out.println(getWeekOfDate(new Date()));
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
