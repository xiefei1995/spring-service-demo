package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/3/24 10:36
 */
public class Demo60 {
	/**
	 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
	 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
	 * <p>
	 * 思路：动态规划，f(x) = f(x-1) + 新加的几率
	 */


	public double[] dicesProbability(int n) {
		// 定义n = 1时的各个数字的概率
		double[] dp = new double[6];
		Arrays.fill(dp, 1.0 / 6.0);
		// 定义n > 1时的dp数组边界
		for (int i = 2; i <= n; i++) {
			// 定义新的dp，用来装扩大之后的概率
			double[] temp = new double[5 * i + 1];
			// 原来的几率
			for (int j = 0; j < dp.length; j++) {
				// 筛子的最大值是6
				for (int k = 0; k < 6; k++) {
					// 计算新dp的每个index的概率
					temp[j + k] += dp[j] / 6.0;
				}
			}
			dp = temp;
		}
		return dp;
	}
}
