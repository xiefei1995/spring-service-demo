package com.goat.calvin.service.provider.domain.leetcode.elementary;

import com.google.inject.internal.cglib.proxy.$CallbackFilter;

/**
 * @author xiefei
 * @date 2022/7/13 12:47
 */
public class Demo8_3 {

	public static boolean isPowerOfThree(int n) {
		if (n == 0) return false;
		if (n == 1) return true;
		if (n % 3 != 0) return false;
		if (n / 3 == 1) return true;
		return isPowerOfThree(n / 3);
	}

	public static boolean isPowerOfThree2(int n) {
		if (n <= 0) return false;
		return 1162261467 % n == 0;
	}

	public static void main(String[] args) {


	}
}
