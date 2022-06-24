package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/6/23 19:18
 */
public class Demo64 {

	private static int res;
	/**
	 * 求 1+2+...+n ，要求不能使用乘除法、for、while、
	 * if、else、switch、case等关键字及条件判断语句（A?B:C）。
	 */
	public static int sumNums(int n) {
		int sum = n;
		// 辅助遍历boolean，要等递归走完之后才会往下走
		boolean flag = n > 0 && (sum += sumNums(n - 1)) > 0;
		return sum;
	}

	public static void main(String[] args) {
		int i = sumNums(9);
		System.out.println(i);
	}
}
