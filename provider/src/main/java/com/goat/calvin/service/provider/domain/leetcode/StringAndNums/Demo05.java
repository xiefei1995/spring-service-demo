package com.goat.calvin.service.provider.domain.leetcode.StringAndNums;

/**
 * @author xiefei
 * @date 2022/6/28 9:12
 */
public class Demo05 {

	/**
	 * 实现一个函数，把字符串 s 中的每个空格替换成"%20"。
	 */
	public String replaceSpace(String s) {
		if (s == null) return null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i) == ' ' ? "%20" : s.charAt(i));
		}
		return sb.toString();
	}
}
