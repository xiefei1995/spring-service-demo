package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/1 12:23
 */
public class Demo2_6 {


	public static int myAtoi(String s) {
		long res = 0;
		String trim = s.trim();
		int symbol = 0;
		for (int i = 0; i < trim.length(); i++) {
			if (i == 0) {
				if (trim.charAt(i) == '-' || trim.charAt(i) == '+') {
					symbol = trim.charAt(i) == '-' ? 1 : 0;
					continue;
				}
			}
			if (!Character.isDigit(trim.charAt(i))) {
				break;
			}
			if (Character.isDigit(trim.charAt(i))) {
				res = res * 10 + trim.charAt(i) - '0';
				if (res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE) {
					break;
				}
			}
		}
		return (int) (symbol == 0 ? Math.min(res, Integer.MAX_VALUE) : Math.max(-res, Integer.MIN_VALUE));
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("9223372036854775808"));
	}
}
