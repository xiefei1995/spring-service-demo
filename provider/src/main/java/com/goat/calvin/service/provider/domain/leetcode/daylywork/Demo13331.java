package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiefei
 * @date 2022/7/28 9:32
 */
public class Demo13331 {

	/**
	 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
	 * 序号代表了一个元素有多大。序号编号的规则如下：
	 * 序号从 1 开始编号。
	 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
	 * 每个数字的序号都应该尽可能地小。
	 */

	public static int[] arrayRankTransform(int[] arr) {
		int[] nums = Arrays.copyOf(arr, arr.length);
		int[] res = new int[arr.length];
		Arrays.sort(nums);
		int index = 1;
		Map<Integer, Integer> indexMap = new HashMap<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			if (!indexMap.containsKey(nums[i])) {
				indexMap.put(nums[i], index++);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			res[i] = indexMap.get(arr[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {40,10,20,30};
		arrayRankTransform(nums);
	}
}
