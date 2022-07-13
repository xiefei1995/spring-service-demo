package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import java.util.*;

/**
 * @author xiefei
 * @date 2022/7/13 9:25
 */
public class Demo735 {

	/**
	 * 给定一个整数数组 asteroids，表示在同一行的行星。
	 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向
	 * （正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
	 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。
	 * 如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
	 */

	public int[] asteroidCollision(int[] asteroids) {
		// 定义队列,队列中装的是最后的值
		Deque<Integer> st = new ArrayDeque<>();
		for (int i = 0; i < asteroids.length; i++) {
			// 只有前一个数为+后一个数为-的情况下才会碰撞
			while (!st.isEmpty() && asteroids[i] < 0 && st.peekLast() > 0) {
				if (asteroids[i] + st.peekLast() < 0) {
					// 如果负数更大，移除队列中的和其比较的正数
					st.pollLast();
				} else if (asteroids[i] + st.peekLast() == 0) {
					// 如果一样大，移除队列中的和其比较的正数，并且将负数的值置为0
					asteroids[i] = 0;
					st.pollLast();
				} else {
					// 正数更大直接将负数置为0
					asteroids[i] = 0;
				}
			}
			// 经过上述的判断如果不为0就直接加入队列
			if (asteroids[i] != 0) {
				st.add(asteroids[i]);
			}
		}

		int[] res = new int[st.size()];
		int index = 0;
		while (!st.isEmpty()) {
			res[index++] = st.poll();
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {-2, 2, -1, -2};
	}
}
