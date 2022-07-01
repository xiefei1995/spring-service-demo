package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/6/28 10:44
 */
public class Demo3 {

	/**
	 * 给你一个数组，将数组中的元素向右轮转 k 个位置，
	 * 其中 k 是非负数。
	 */

	public static void rotate(int[] nums, int k) {
		int[] temp = Arrays.copyOf(nums, nums.length);
		int m = k / nums.length;
		for (int i = 0; i < nums.length; i++) {
			// 右移动，等于上k个位置的值
			nums[i] = temp[(i + (m + 1) * nums.length - k) % nums.length];
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2};
		rotate(nums, 3);
	}
}
