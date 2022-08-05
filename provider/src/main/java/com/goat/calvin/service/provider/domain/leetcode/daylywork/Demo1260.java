package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/7/20 10:41
 */
public class Demo1260 {
	/**
	 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
	 * 每次「迁移」操作将会引发下述活动：
	 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
	 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
	 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
	 * 请你返回 k 次迁移操作后最终得到的 二维网格。
	 */

	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		int m = grid.length;
		int n = grid[0].length;
		int[][] nums = new int[m][n];
		// 根据题意他是列在移动，对每列的每一个元素移动
		for (int i = 0; i < n; i++) {
			// 移动后列的位置
			int col = (i + k) % n;
			// 移动后每行第一个元素行的起点
			int row = ((i + k) / n) % m;
			// 定义每一行的起点
			int index = 0;
			while (index != m) {
				nums[row++][col] = grid[index++][i];
				// 如果超过m就换行
				if (row == m) {
					row = 0;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				list.add(nums[i][j]);
			}
			ans.add(list);
		}
		return ans;
	}
}
