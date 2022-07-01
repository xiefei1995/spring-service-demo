package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author xiefei
 * @date 2022/6/29 9:29
 */
public class Demo8 {

	/**
	 * 将数组中的0放到最后
	 */
	public static void moveZeroes(int[] nums) {
		// 统计数字前面0的个数，做位移
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
			} else if (i > 0) {
				nums[i - count] = nums[i];
				if (count > 0) {
					nums[i] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {2, 1};
		moveZeroes(nums);
	}
}
