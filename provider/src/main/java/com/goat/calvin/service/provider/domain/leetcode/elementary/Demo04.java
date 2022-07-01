package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/6/28 11:29
 */
public class Demo04 {

	/**
	 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，
	 * 返回 true ；如果数组中每个元素互不相同，返回 false
	 */
	public static boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 1) return false;
		// 双指针
		for (int i = 0; i < nums.length - 1; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left <= right) {
				if (nums[i] == nums[left] || nums[i] == nums[right]) {
					return true;
				}
				left++;
				right--;
			}
		}
		return false;
	}

	public static boolean containsDuplicate2(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == nums[i + 1]) {
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		System.out.println(containsDuplicate(nums));
	}
}
