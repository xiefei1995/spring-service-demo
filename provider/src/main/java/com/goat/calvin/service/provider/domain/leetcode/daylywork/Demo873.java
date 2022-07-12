package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import java.util.*;

/**
 * @author xiefei
 * @date 2022/7/9 10:07
 */
public class Demo873 {


	/**
	 * 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
	 * n >= 3
	 * 对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
	 * 给定一个严格递增的正整数数组形成序列 arr ，找到 arr 中最长的斐波那契式的子序列的长度。
	 * 如果一个不存在，返回  0 。
	 */

	public static int lenLongestFibSubseq(int[] arr) {
		int res = 0;
		List<Integer> list = new ArrayList<>();
		// 第一位数
		for (int i = 0; i < arr.length - 2; i++) {
			list.clear();
			list.add(arr[i]);
			// 第二位数
			for (int j = i + 1; j < arr.length - 1; j++) {
				list.clear();
				list.add(arr[i]);
				list.add(arr[j]);
				// 第三位数
				for (int k = j + 1; k < arr.length; k++) {
					if (list.get(list.size() - 1) + list.get(list.size() - 2) == arr[k]) {
						list.add(arr[k]);
					}
				}
				res = list.size() > 2 ? Math.max(res, list.size()) : res;
				// 剪枝
				list.clear();
			}
		}
		return res;
	}


	public static int lenLongestFibSubseqs(int[] arr) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>(arr.length);
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int pre = arr[i];
				int cur = arr[j];
				int count = 2;
				while (map.containsKey(pre + cur)) {
					// 这里属于是动态规划了
					count++;
					int temp = cur;
					cur = map.get(pre + cur);
					pre = temp;
				}
				if (count > 2) {
					res = Math.max(res, count);
				}
			}
		}
		return res;

	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(lenLongestFibSubseqs(nums));
	}
}
