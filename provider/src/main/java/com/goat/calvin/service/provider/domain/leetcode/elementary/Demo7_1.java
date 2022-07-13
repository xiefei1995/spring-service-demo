package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.Random;

/**
 * @author xiefei
 * @date 2022/7/12 10:53
 */
public class Demo7_1 {

	/**
	 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
	 * 打乱后，数组的所有排列应该是 等可能 的。
	 * <p>
	 * 实现 Solution class:
	 * <p>
	 * Solution(int[] nums) 使用整数数组 nums 初始化对象
	 * int[] reset() 重设数组到它的初始状态并返回
	 * int[] shuffle() 返回数组随机打乱后的结果
	 */

	class Solution {

		int[] nums;

		public Solution(int[] nums) {
			this.nums = nums;
		}

		/**
		 * Resets the array to its original configuration and return it.
		 */
		public int[] reset() {
			return nums;
		}

		/**
		 * Returns a random shuffling of the array.
		 */
		public int[] shuffle() {
			int[] a = nums.clone();
			// 随机算法，如果随机到非自己就交换
			Random random = new Random();
			for (int i = 0; i < nums.length; i++) {
				int j = random.nextInt(i + 1);
				if (i != j) {
					// 交换
					int temp = a[i];
					a[i] = a[j];
					a[j] = a[temp];
				}
			}
			return a;
		}
	}
}
