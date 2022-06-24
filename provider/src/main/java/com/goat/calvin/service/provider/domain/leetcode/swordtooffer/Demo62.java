package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/6/23 13:39
 */
public class Demo62 {

	/**
	 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，
	 * 每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
	 * 求出这个圆圈里剩下的最后一个数字。
	 * 例如，0、1、2、3、4这5个数字组成一个圆圈，
	 * 从数字0开始每次删除第3个数字，
	 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
	 */

	public static int lastRemaining(int n, int m) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		// 初始坐标
		int index = 0;
		while (n > 1) {
			// 初始值 + 第几个的值 对数组长度取模得到真实移动的值
			index = (index + (m - 1)) % n;
			list.remove(index);
			n--;
		}
		return list.get(0);
	}

	public int lastRemaining2(int n, int m) {
		// 约瑟夫环
		int[] dp = new int[n + 1];
		// 只有一个数并且只剩一个数指定是0
		dp[1] = 0;
		// 公式：dp[i] = i - 1的位置 + 移动值对当前的n取，遇到dp看规律
		// 公式：dp[i] = (dp[i-1] + m%i)%i;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + m % i) % i;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(lastRemaining(5, 3));
	}
}
