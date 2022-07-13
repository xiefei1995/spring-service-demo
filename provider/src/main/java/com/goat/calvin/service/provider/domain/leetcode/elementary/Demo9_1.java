package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/13 13:56
 */
public class Demo9_1 {


	/**
	 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
	 * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
	 */

	public static int hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			// & 1 == 1 是奇数， = 0是偶数
			count += n & 1;
			// 带符号除2
			n = n >>> 1;
		}
		return count;
	}


	public static void main(String[] args) {
		System.out.println(hammingWeight(Integer.MAX_VALUE));
	}
}
