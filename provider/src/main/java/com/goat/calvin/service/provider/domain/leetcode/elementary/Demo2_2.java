package com.goat.calvin.service.provider.domain.leetcode.elementary;

import com.google.inject.internal.cglib.proxy.$Callback;

import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/6/30 15:08
 */
public class Demo2_2 {
	/**
	 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
	 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
	 */

	public int reverse(int x) {
		String numStr = String.valueOf(x);
		int flag = 0;
		if (numStr.startsWith("-")) {
			flag = 1;
			numStr = numStr.substring(1);
		}
		int left = 0;
		char[] chars = numStr.toCharArray();
		int right = chars.length - 1;
		while (left < right) {
			char temp = chars[left];
			chars[left++] = chars[right];
			chars[right--] = temp;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			sb.append(chars[i]);
		}
		String res = sb.toString();
		if (res.length() == 1) return flag == 0 ?
				Integer.parseInt(res) : -Integer.parseInt(res);
		return flag == 0 ?
				Integer.parseInt(deleteFirstZero(res)) : -Integer.parseInt(deleteFirstZero(res));
	}

	public String deleteFirstZero(String str) {
		if (!str.startsWith("0")) {
			String s = String.valueOf(Integer.MAX_VALUE);
			if (s.length() == str.length() && str.compareTo(s) > 0) {
				return "0";
			}
			return str;
		}
		str = str.substring(1);
		return deleteFirstZero(str);
	}

	public int reverse2(int x) {
		long res = 0;
		while (x != 0) {
			// 反转数每反转一次就*10再加上每次的余数
			res = res * 10 + x % 10;
			x /= 10;
		}
		return (int) res == res ? (int) res : 0;
	}

}
