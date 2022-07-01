package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author xiefei
 * @date 2022/6/28 12:27
 */
public class Demo5 {

	/**
	 * 给定一个非空整数数组，除了某个元素只出现一次以外，
	 * 其余每个元素均出现两次。找出那个只出现了一次的元素。
	 */

	public int singleNumber(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i += 2) {
			if (nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}
		return nums[nums.length - 1];
	}

	public int singleNumber2(int[] nums) {
		// 1. 0 ^ 任意数= 任意数
		// 2. 任意数 ^ 任意数 = 0
		// 3. a ^ b = b ^ a
		int result = 0;
		for (int i = 0; i < nums.length ; i++) {
			result ^= nums[i];
		}
		return result;
	}

}
