package com.caoc.test.steams.comparator;

import lombok.Data;
import org.apache.tomcat.jni.Local;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SteamComparator {

	public static void main(String[] args) throws ParseException {
		List<Card> cardList = new ArrayList<>();
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDate now = LocalDate.now();
		LocalDate data1 = LocalDate.of(2019, 9, 11);

		Instant instant = now.atStartOfDay().atZone(zoneId).toInstant();
		Instant instant1 = data1.atStartOfDay().atZone(zoneId).toInstant();
		Card card = new Card();
		card.setCardDate(Date.from(instant1));
		card.setCardNo("1");

		Card card1 = new Card();
		card1.setCardNo("2");
		card1.setCardDate(Date.from(instant));

		Card card2 = new Card();
		card2.setCardNo("3");
		card2.setCardDate(null);


		cardList.add(card);
		cardList.add(card1);
		cardList.add(card2);
		cardList.add(card2);


		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1900 = dateFormat.parse("1900-01-01");
		System.out.println(date1900.getTime());
		long date1900l = -2209017600000L;
		System.out.println(new Date(date1900l));


		System.out.println(
				cardList.stream().sorted((d1, d2) ->
				{
					Date dd1 = d1.getCardDate();
					Date dd2 = d2.getCardDate();
					if (dd1 == null) {
						dd1 = new Date(date1900l);
					}
					if (dd2 == null) {
						dd2 = new Date(date1900l);
					}
					return dd2.compareTo(dd1);

				})
						.map(v -> v.getCardDate())
						.collect(Collectors.toList()));

	}

	@Data
	static class Card {
		private String cardNo;
		private Date cardDate;
	}
}
