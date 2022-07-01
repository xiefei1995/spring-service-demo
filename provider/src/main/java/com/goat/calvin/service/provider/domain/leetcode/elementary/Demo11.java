package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/6/30 9:24
 */
public class Demo11 {


	/**
	 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度
	 * <p>
	 * 思路：行变列，列变行
	 */
	public void rotate(int[][] matrix) {
		int length = matrix.length;
		//因为是对称的，只需要计算循环前半行即可
		for (int i = 0; i < length / 2; i++) {
			for (int j = i; j < length - i - 1; j++) {
				int temp = matrix[i][j];
				int m = length - j - 1;
				int n = length - i - 1;
				// 左到右
				matrix[i][j] = matrix[m][i];
				// 上到下
				matrix[m][i] = matrix[n][m];
				// 右到做
				matrix[n][m] = matrix[j][n];
				// 下到上
				matrix[j][n] = temp;
			}
		}
	}
}
