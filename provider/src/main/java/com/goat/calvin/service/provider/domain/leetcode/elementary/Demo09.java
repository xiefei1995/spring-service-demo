package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.*;

/**
 * @author xiefei
 * @date 2022/6/29 10:05
 */
public class Demo09 {

	/**
	 * 两数之和为target求坐标
	 * <p>
	 * 思路：动态将值放入map，值为key，index为value
	 */
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			if (map.get(target - nums[i]) != null) {
				return new int[]{i, map.get(target - nums[i])};
			}
			map.put(nums[i], i);
		}
		return new int[2];
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		twoSum(nums, 6);
	}
}
