package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.*;

/**
 * @author xiefei
 * @date 2022/6/21 15:37
 */
public class Demo56 {

	/**
	 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
	 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
	 */
	public int[] singleNumbers(int[] nums) {
		int x = 0, y = 0, n = 0, m = 1;
		for (int num : nums)               // 1. 遍历异或
			n ^= num;
		while ((n & m) == 0)               // 2. 循环左移，计算 m
			m <<= 1;
		for (int num : nums) {              // 3. 遍历 nums 分组
			if ((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
			else y ^= num;                // 4. 当 num & m == 0
		}
		return new int[]{x, y};          // 5. 返回出现一次的数字
	}

	/**
	 * 在一个数组 nums 中除一个数字只出现一次之外，
	 * 其他数字都出现了三次。请找出那个只出现一次的数字。
	 */
	public static int singleNumber(int[] nums) {
		List<String> list = new ArrayList<>();
		List<String> used = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			String str = String.valueOf(nums[i]);
			if (list.contains(str)) {
				list.remove(str);
				used.add(str);
			} else if (!used.contains(str)) {
				list.add(str);
			}
		}
		return Integer.parseInt(list.get(0));
	}

	public static void main(String[] args) {
		int[] nums = {5, 2, 2, 2, 5, 5, 4};
		System.out.println(singleNumber(nums));
	}
}
