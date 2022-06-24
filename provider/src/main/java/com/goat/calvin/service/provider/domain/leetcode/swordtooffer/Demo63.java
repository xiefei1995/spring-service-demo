package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/6/23 18:49
 */
public class Demo63 {

	/**
	 * 假设把某股票的价格按照时间先后顺序存储在数组中，
	 * 请问买卖该股票一次可能获得的最大利润是多少？
	 */

	public int maxProfit(int[] prices) {
		int res = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i; j < prices.length; j++) {
				res = Math.max(prices[j] - prices[i], res);
			}
		}
		return res;
	}

	public int maxProfit2(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int pre = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			// 只算正，记录res，然后pre谁小取谁
			pre = Math.min(pre, prices[i]);
			res = Math.max(res, prices[i] - pre);
		}
		return res;
	}
}
