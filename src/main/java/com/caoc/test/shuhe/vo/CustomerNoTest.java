package com.caoc.test.shuhe.vo;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Slf4j
public class CustomerNoTest {

	/**
	 * 从2020年开始
	 */
	private final static char[] years = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
			'U', 'V', 'W', 'X', 'Y', 'Z'};
	/**
	 * 月
	 */
	private final static char[] months = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B','C'};
	/**
	 * 日
	 */
	private final static  char[] days = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U','V'};

	private final static int SECONDS_COUNT = 60;


	/**
	 * 	 * cusOrderNo=客户号后8位+年月日3位缩编码+当日秒数5位（不足前面补0，最大值86400）=16位编码
	 * 	 * <p>
	 * 	 * 年：从2020年开始依次从0~9,A~Z 顺序递增。可以支撑36年，占用1位（如果考虑大小写区分，可以额外再支撑26年）
	 * 	 * <p>
	 * 	 * 月：1~12依次对应1,2,3,4,5,6,7,8,9,A,B,C，占用1位
	 * 	 * <p>
	 * 	 * 日：1~31号，1~9 对应数字1~9，10~31 用A~Z字母依次对应，占用1位
	 * 	 * <p>
	 * 	 * 5位当日秒数：每日日从0点开始算，次日重置。最大值为86400,不足5位，前面补0。
	 * 	 * <p>
	 * 	 * 举例:客户号0159777544在2020年5月7号23点34分12秒，发起的一笔订单，生成的客户订单号为:5977754405784852
	 * 	 * <p>
	 * 	 * 客户号0159777544在2032年11月27号23点34分12秒，发起的一笔订单，生成的客户订单号为:59777544BBR84852
	 *
	 * @param
	 * @return
	 */



	public static void main(String[] args) {

		String customerNo = "159777544";
		LocalDateTime localDateTime = LocalDateTime.of(2020, 5, 7, 23, 34, 12);
		int current_seconds_from_0 = localDateTime.getHour() * SECONDS_COUNT * SECONDS_COUNT + localDateTime.getMinute() * SECONDS_COUNT + localDateTime.getSecond();

		int year = localDateTime.getYear();
		int month = localDateTime.getMonthValue();
		int day = localDateTime.getDayOfMonth();
		int hour = localDateTime.getHour();
		int minute = localDateTime.getMinute();
		int second = localDateTime.getSecond();

		log.info("year->{}",year);
		log.info("month->{}",month);
		log.info("day->{}",day);
		log.info("hour->{}",hour);
		log.info("minute->{}",minute);
		log.info("second->{}",second);



		StringBuilder sb = new StringBuilder();
		sb.append(StringUtils.length(customerNo) > 8 ? customerNo.substring(customerNo.length() - 8)
				: Strings.padStart(customerNo, 8, '0'))
				.append(years[localDateTime.getYear() - 2020])
				.append(months[localDateTime.getMonthValue() - 1])
				.append(days[localDateTime.getDayOfMonth() - 1])
				.append(Strings.padStart(Integer.toString(current_seconds_from_0), 5, '0'));

		log.info("cusOrderNoNew->{}",sb.toString());
		log.info("cusOrderNoNew.length->{}",sb.toString().length());












	}
}
