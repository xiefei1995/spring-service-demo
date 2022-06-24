package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xiefei
 * @date 2022/6/21 19:02
 */
public class Demo57_2 {
	/**
	 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
	 * <p>
	 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
	 */
	public static int[][] findContinuousSequence(int target) {
		// 找到中间值
		int mid = target / 2 + 1;
		int temp = 0;
		List<int[]> resList = new ArrayList<>();
		LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
		while (mid > 0) {
			temp += mid;
			queue.add(mid);
			if (temp == target) {
				int[] nums = new int[queue.size()];
				for (int i = queue.size() - 1; i >= 0; i--) {
					nums[i] = queue.poll();
				}
				resList.add(0, nums);
				queue.clear();
				mid = nums[nums.length - 1];
				temp = 0;
			}
			if (temp > target) {
				Integer peek = queue.peek();
				// 利用queue先进先出的特性做滑动窗口
				queue.poll();
				temp -= peek;
			}
			mid--;
		}
		return resList.toArray(new int[0][]);
	}

	public static void main(String[] args) {
		int[][] continuousSequence = findContinuousSequence(15);
		System.out.println(1);
	}
}
