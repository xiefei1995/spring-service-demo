package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/7/12 12:39
 */
public class Demo8_2 {

	/**
	 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
	 */
	public int countPrimes(int n) {
		boolean[] arr = new boolean[n];
		int cnt = 0;
		for(int i = 2; i < n; i++) {
			if(arr[i]) continue;
			cnt++;
			// 将i的倍数全部给放进去
			for(int j = i; j < n; j+=i) {
				arr[j] = true;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		String beginTime =null;
		beginTime = beginTime == null ? "1900-01-01" : beginTime;
		System.out.println(beginTime);
	}
}
