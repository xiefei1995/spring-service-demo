package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/6/28 10:19
 */
public class Demo2 {


	/**
	 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
	 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。
	 * 你也可以先购买，然后在 同一天 出售。
	 * 返回 你能获得的 最大 利润 。
	 */

	public static int maxProfit(int[] prices) {
		// 求最大利润
		int res = 0;
		int result = 0;
		int pre = prices[0];
		for (int i = 1; i < prices.length; i++) {
			// 每天的利润
			int tempPro = prices[i] - pre;
			// 目前利润 < 当前最大利润时,换pre
			if (tempPro < res) {
				pre = prices[i];
				result += res;
				res = 0;
			} else {
				res = tempPro;
			}
		}
		return result + res;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		maxProfit(nums);
	}

}
