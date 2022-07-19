package com.goat.calvin.service.provider.domain.leetcode.daylywork;


/**
 * @author xiefei
 * @date 2022/7/18 10:40
 */
public class Demo565 {

	public static int arrayNesting(int[] nums) {
		int n = nums.length;
		int res = 0;
		for (int i = 0; i < n; i++) {
			int cur = i;
			int count = 0;
			// 以每一个index为起点来算他的最大值
			while (nums[cur] != -1) {
				count++;
				int temp = nums[cur];
				// 被使用过的都置为-1,因为不必找了，之前都出现过了的
				nums[cur] = -1;
				cur = temp;
			}
			res = Math.max(res, count);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {5, 4, 0, 3, 1, 6, 2};
		System.out.println(arrayNesting(nums));
	}
}
