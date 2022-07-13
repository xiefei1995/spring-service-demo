package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/7/12 12:24
 */
public class Demo8_1 {
	public static List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				list.add("FizzBuzz");
				continue;
			}
			if (i % 3 == 0) {
				list.add("Fizz");
				continue;
			}
			if (i % 5 == 0) {
				list.add("Buzz");
				continue;
			}
			list.add(String.valueOf(i));
		}
		return list;
	}

	public static void main(String[] args) {
		List<String> list = fizzBuzz(1000);
		for (String str : list) {
			System.out.println(str);
		}

	}
}
