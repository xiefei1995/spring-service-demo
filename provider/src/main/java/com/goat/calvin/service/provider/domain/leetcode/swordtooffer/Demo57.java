package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/6/21 18:00
 */
public class Demo57 {

	/**
	 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，
	 * 使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
	 *
	 * 递增，用双指针定位法
	 */
	public int[] twoSum(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				return new int[]{nums[left], nums[right]};
			}
			if (nums[left] + nums[right] > target) {
				right--;
			}
			if (nums[left] + nums[right] < target) {
				left++;
			}
		}
		return new int[2];
	}
}
