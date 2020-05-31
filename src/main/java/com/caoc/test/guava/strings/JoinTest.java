package com.caoc.test.guava.strings;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JoinTest {
	public static void main(String[] args) {
		Joiner joiner = Joiner.on("-").skipNulls();
		System.out.println(joiner.join(IntStream.range(1, 10).mapToObj(t -> t).collect(Collectors.toList())));

		System.out.println("123".substring(1));
		partitionByCurrentPosition(16, 16, (16-2)/2, 1);

	}


	private static Map<String, List<Integer>> partitionByCurrentPosition(int currentPosition, int size, int range, int downCal) {
		//暂时不知到具体位置的信息
		//假设16个柜子 分半考虑的时候是  当前位置 下1 上5  中上 与中下各一不参加计算
		//所以对每一个当前行 的行为就是 -1 +4 设置为左  -2 +5 位置设置不参与 其余设置为右
		List<Integer> left = Lists.newArrayList();
		int down = downCal;
		int up = range - downCal - 1;
		IntStream.rangeClosed(1, down).forEach(t -> left.add(currentPosition - t <= 0 ? size - t + 1 : currentPosition - t));
		left.add(currentPosition);
		IntStream.rangeClosed(1, up).forEach(t -> left.add(currentPosition + t > size ? currentPosition + t - size : currentPosition + t));
		//忽略重量2个位置
		List<Integer> ignore = Lists.newArrayList();
		ignore.add(left.get(0) - 1 == 0 ? size : left.get(0) - 1);
		ignore.add(left.get(left.size() - 1) + 1 >= size ? 1 : left.get(left.size() - 1) + 1);

		List<Integer> right = IntStream.rangeClosed(1, size)
				.filter(t -> !(left.contains(t) || ignore.contains(t))).boxed().collect(Collectors.toList());

		Map<String, List<Integer>> listMap = Maps.newHashMap();
		listMap.put("left", left);
		listMap.put("right", right);
		return listMap;
	}
}
