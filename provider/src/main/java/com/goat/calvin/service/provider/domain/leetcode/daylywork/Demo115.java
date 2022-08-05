package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import java.util.*;

/**
 * @author xiefei
 * @date 2022/7/23 10:49
 */
public class Demo115 {

	/**
	 * 给定一个长度为 n 的整数数组 nums ，其中 nums 是范围为 [1，n] 的整数的排列。还提供了一个 2D 整数数组 sequences ，其中 sequences[i] 是 nums 的子序列。
	 * 检查 nums 是否是唯一的最短 超序列 。最短 超序列 是 长度最短 的序列，并且所有序列 sequences[i] 都是它的子序列。对于给定的数组 sequences ，可能存在多个有效的 超序列 。
	 * <p>
	 * 例如，对于 sequences = [[1,2],[1,3]] ，有两个最短的 超序列 ，[1,2,3] 和 [1,3,2] 。
	 * 而对于 sequences = [[1,2],[1,3],[1,2,3]] ，唯一可能的最短 超序列 是 [1,2,3] 。[1,2,3,4] 是可能的超序列，但不是最短的。
	 * 如果 nums 是序列的唯一最短 超序列 ，则返回 true ，否则返回 false 。
	 * 子序列 是一个可以通过从另一个序列中删除一些元素或不删除任何元素，而不改变其余元素的顺序的序列
	 */

	public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
		//转化成边
		Map<Integer, Set<Integer>> edge = new HashMap<>();
		//记录入度
		int[] inDegree = new int[nums.length + 1];
		for (int[] sequence : sequences) {
			//注意这里是一个子序列，有多个元素，不是两个
			for (int i = 1; i < sequence.length; i++) {
				int from = sequence[i - 1];
				int to = sequence[i];
				//判断是否有此条边
				if (edge.containsKey(from) && edge.get(from).contains(to)) {
					continue;
				}
				edge.putIfAbsent(from, new HashSet<>());
				edge.get(from).add(to);
				inDegree[to]++;
			}
		}
		//记录入度为0的点
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= nums.length; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			//存在多个入度为0的点 会有多个超序列 直接返回false
			if (queue.size() > 1) {
				return false;
			}
			int from = queue.poll();
			Set<Integer> set = edge.get(from);
			if (set == null) {
				continue;
			}
			//和此点连通的点入度减一
			for (int point : set) {
				inDegree[point]--;
				if (inDegree[point] == 0) {
					queue.add(point);
				}
			}
		}
		return true;
	}

}
