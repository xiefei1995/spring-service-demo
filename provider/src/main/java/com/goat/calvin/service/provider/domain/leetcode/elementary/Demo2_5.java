package com.goat.calvin.service.provider.domain.leetcode.elementary;

import com.google.inject.internal.cglib.proxy.$Dispatcher;

import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/7/1 11:19
 */
public class Demo2_5 {

	/**
	 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
	 * <p>
	 * 说明：本题中，我们将空字符串定义为有效的回文串
	 */

	public static boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}
			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
