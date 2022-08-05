package com.goat.calvin.service.provider.domain.leetcode.leetcode75.level1;

import com.google.inject.internal.cglib.core.$ClassNameReader;

/**
 * @author xiefei
 * @date 2022/7/20 13:41
 */
public class Demo1480 {

	/**
	 * 给你一个数组 nums 。数组「动态和」的计算公式为：
	 * runningSum[i] = sum(nums[0]…nums[i]) 。
	 * <p>
	 * 请返回 nums 的动态和。
	 */


	public int[] runningSum(int[] nums) {
		int[] res = new int[nums.length];
		int preRes = 0;
		for (int i = 0; i < nums.length; i++) {
			res[i] = preRes + nums[i];
			preRes = res[i];
		}
		return res;
	}
}
