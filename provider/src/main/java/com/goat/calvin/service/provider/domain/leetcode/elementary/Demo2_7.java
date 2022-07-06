package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/1 12:55
 */
public class Demo2_7 {

	/**
	 * 实现 strStr() 函数。
	 * 给你两个字符串 haystack 和 needle ，
	 * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置
	 * （下标从 0 开始）。如果不存在，则返回  -1 。
	 * 说明：
	 * 当 needle 是空字符串时，我们应当返回什么值呢？
	 * 这是一个在面试中很好的问题。
	 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
	 * 这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
	 */

	public static int strStr(String haystack, String needle) {
		int[] indexNum = new int[needle.length()];
		char[] hay = haystack.toCharArray();
		char[] need = needle.toCharArray();
		int index = 0;
		for (int i = 0; i < hay.length; i++) {
			if (hay[i] == need[index]) {
				indexNum[index] = i;
				index++;
				if (index == need.length) {
					return i - index + 1;
				}
			} else {
				if (index > 0) {
					index = 0;
					i = indexNum[0];
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(strStr("happy", "h"));
	}
}
