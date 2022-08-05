package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/7/22 9:55
 */
public class Demo757 {

	/**
	 * 一个整数区间 [a, b]  ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b。
	 * <p>
	 * 给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。
	 * <p>
	 * 输出这个最小集合S的大小。
	 * <p>
	 * 注意：本题最终得到的[]中的元素也是区间而非全部元素，尾排法
	 */
	public int intersectionSizeTwo(int[][] intervals) {
		// 对二维数组的1位置上的数字排序
		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
		// 找到最小的数字的区间:[right-1,right]
		int begin = intervals[0][1] - 1;
		int end = intervals[0][1];
		// 最小情况为2
		int res = 2;
		// 和下一个区间比较
		for (int i = 1; i < intervals.length; i++) {
			int[] nums = intervals[i];
			// 左边界
			int left = nums[0];
			// 右边界:PS 因为排了序，右边界指定上一个区间的右边界大，所以不做比较
			int right = nums[1];
			if (left < begin) {
				continue;
			}
			// 左区间比上右区间大直接res直接+2
			// 新base区间修改为[right-1,right]
			if (left > end) {
				res += 2;
				begin = right - 1;
				end = right;
				// 左区间比上左区间大或者和上右区间相等，res+=1
			} else if (left > begin || left == end) {
				res++;
				// 新区间是上区间的结尾
				begin = end;
				end = right;
			}
		}
		return res;
	}
}
