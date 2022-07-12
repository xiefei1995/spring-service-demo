package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/7 14:41
 */
public class Demo6_3 {
	// 最大子集和
	public int maxSubArray(int[] nums) {
		int res = nums[0];
		// 定义当前元素之前的连续元素之和
		int pre = nums[0];
		for (int i = 1; i < nums.length; i++) {
			pre = Math.max(nums[i] + pre, nums[i]);
			// 比较每段最大的值
			res = Math.max(res, pre);
		}
		return res;
	}
}
