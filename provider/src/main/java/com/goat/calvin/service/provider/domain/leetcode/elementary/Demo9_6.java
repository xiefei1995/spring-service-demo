package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/7/13 16:23
 */
public class Demo9_6 {

	/**
	 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
	 */
	public static int missingNumber(int[] nums) {
		//  & | ^的考核
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res = res ^ (nums[i] ^ (i + 1));
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
		System.out.println(missingNumber(nums));
	}
}
