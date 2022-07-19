package com.goat.calvin.service.provider.domain.leetcode.daylywork;

/**
 * @author xiefei
 * @date 2022/7/18 9:23
 */
public class Demo041 {

	class MovingAverage {

		/**
		 * Initialize your data structure here.
		 */
		int[] arr = new int[10010];
		// i表示右边坐标j表示左边坐标
		int n, sum, j, i;
		public MovingAverage(int size) {
			n = size;
		}
		public double next(int val) {
			sum += arr[i++] = val;
			if (i - j > n) sum -= arr[j++];
			return sum * 1.0 / (i - j);
		}
	}
}
