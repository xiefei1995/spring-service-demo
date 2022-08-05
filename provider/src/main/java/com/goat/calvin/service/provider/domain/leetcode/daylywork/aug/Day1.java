package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

/**
 * @author xiefei
 * @date 2022/8/1 9:42
 */
public class Day1 {

	/**
	 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
	 * <p>
	 * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
	 */
	public String generateTheString(int n) {
		StringBuilder sb = new StringBuilder();
		if ((n & 1) == 1) {
			for (int i = 0; i < n; i++) {
				sb.append('a');
			}
			return sb.toString();
		}
		for (int i = 0; i < n - 1; i++) {
			sb.append('a');
		}
		return sb.append('b').toString();
	}
}
