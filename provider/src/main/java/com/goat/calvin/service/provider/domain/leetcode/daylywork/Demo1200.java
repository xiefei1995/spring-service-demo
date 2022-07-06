package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/7/4 11:23
 */
public class Demo1200 {
	/**
	 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回
	 */
	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.sort(arr);
		List<List<Integer>> res = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			List<Integer> list = new ArrayList<>();
			int diff = Math.abs(arr[i + 1] - arr[i]);
			if (diff == min) {
				list.add(arr[i]);
				list.add(arr[i + 1]);
				res.add(list);
			}
			if (diff < min) {
				res.clear();
				list.add(arr[i]);
				list.add(arr[i + 1]);
				res.add(list);
				min = arr[i + 1] - arr[i];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 1};
		minimumAbsDifference(arr);
	}
}
