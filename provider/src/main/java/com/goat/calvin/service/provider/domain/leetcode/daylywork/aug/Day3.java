package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/8/3 9:24
 */
public class Day3 {

	/**
	 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
	 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
	 */
	public static String orderlyQueue(String s, int k) {
		if (k == 1) {
			//模拟往后移一个元素
			StringBuilder sb = new StringBuilder(s);
			for (int i = 1; i < s.length(); i++) {
				//第一个元素移动到最后
				sb.append(sb.charAt(0)).deleteCharAt(0);
				// 比较一圈
				if (sb.toString().compareTo(s) < 0) {
					s = sb.toString();
				}
			}
			return s;
		} else {
			//直接排序
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			return new String(chars);
		}

	}

	public static void main(String[] args) {
		String a = "ceabcdab";
		System.out.println(orderlyQueue(a, 1));
	}
}
