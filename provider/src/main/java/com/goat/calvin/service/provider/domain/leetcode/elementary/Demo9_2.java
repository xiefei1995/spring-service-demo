package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/13 14:26
 */
public class Demo9_2 {


	/**
	 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
	 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
	 */
	public static int hammingDistance(int x, int y) {
		int count = 0;
		while (x != 0 || y != 0) {
			if ((x & 1) != (y & 1)) count++;
			x = x >>> 1;
			y = y >>> 1;
		}
		return count;
	}


	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}
}
