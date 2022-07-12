package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/7 12:28
 */
public class Demo5_2 {

	public static int firstBadVersion(int n) {
		// 二分
		int left = 0;
		int right = n;
		int res = -1;
		while (left <= right) {
			int mid = ((right - left) >> 1) + left;
			if (isBadVersion(mid)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			res = left;
		}
		return res;
	}

	static boolean isBadVersion(int version) {
		return version >= 1 ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(firstBadVersion(3));
	}

}
