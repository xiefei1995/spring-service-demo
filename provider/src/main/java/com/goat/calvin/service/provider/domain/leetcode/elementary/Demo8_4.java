package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiefei
 * @date 2022/7/13 13:02
 */
public class Demo8_4 {

	/**
	 * 字符          数值
	 * I             1
	 * V             5
	 * X             10
	 * L             50
	 * C             100
	 * D             500
	 * M             1000
	 * 49 应该写作 XLIX，999 应该写作 CMXCIX
	 */
	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>(7);
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		char[] chars = s.toCharArray();
		int res = 0;
		for (int i = 0; i < chars.length; i++) {
			// 需要减的
			if (i < chars.length - 1 && map.get(chars[i]) < map.get(chars[i + 1])) {
				res += map.get(chars[i + 1]) - map.get(chars[i]);
				i++;
			} else {
				res += map.get(chars[i]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("CCC"));
	}
}
