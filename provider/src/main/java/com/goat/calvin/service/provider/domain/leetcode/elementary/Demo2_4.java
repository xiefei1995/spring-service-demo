package com.goat.calvin.service.provider.domain.leetcode.elementary;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/6/30 17:33
 */
public class Demo2_4 {

	/**
	 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
	 * <p>
	 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
	 */

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		Arrays.sort(sChars);
		Arrays.sort(tChars);

		return Arrays.equals(tChars, sChars);
	}
}
