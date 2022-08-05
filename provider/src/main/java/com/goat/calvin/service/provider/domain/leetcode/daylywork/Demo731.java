package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author xiefei
 * @date 2022/7/19 9:22
 */
public class Demo731 {

	/**
	 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
	 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，
	 * 注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
	 * 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
	 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。
	 * 否则，返回 false 并且不要将该日程安排添加到日历中。
	 * 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
	 */
	static class MyCalendarTwo {
		TreeMap<Integer, Integer> map;

		public MyCalendarTwo() {
			map = new TreeMap<>();
		}

		public boolean book(int start, int end) {
			// 先全部加进去再来判断 +表示闭区间 -表示开区间
			map.put(start, map.getOrDefault(start, 0) + 1);
			map.put(end, map.getOrDefault(end, 0) - 1);
			int crossCount = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				// 校验map中出现的次数
				if ((crossCount += entry.getValue()) > 2) {
					map.put(start, map.getOrDefault(start, 0) - 1);
					map.put(end, map.getOrDefault(end, 0) + 1);
					return false;
				}
			}
			return true;
		}
	}


}
