package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/6/29 10:43
 */
public class Demo10 {
	/**
	 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，
	 * 验证已经填入的数字是否有效即可。
	 * 数字 1-9 在每一行只能出现一次。
	 * 数字 1-9 在每一列只能出现一次。
	 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
	 * 注意：
	 * 一个有效的数独（部分已被填充）不一定是可解的。
	 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
	 * 空白格用 '.' 表示。
	 */
	public boolean isValidSudoku(char[][] board) {
		// 定义三个数组来放数据,如果计算出来的位置有数据存在说明有重复数据
		// 行
		int[][] row = new int[9][9];
		// 列
		int[][] col = new int[9][9];
		// 小范围拼接出来的大范围
		int[][] small = new int[9][9];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				// 空白处跳过
				if (board[i][j] == '.') {
					continue;
				}
				// 将值转换为integer格式并将其转为index
				int index = board[i][j] - '0' - 1;
				// 对内部小区域分析
				// k是第几个单元格，9宫格数独横着和竖着都是3个单元格
				int k = (i / 3) * 3 + j / 3;
				if (row[i][index] != 0 || col[index][j] != 0 || small[k][index] != 0) {
					return false;
				}
				// 填充值
				row[i][index] = col[index][j] = small[k][index] = 1;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println('.' - '0');
	}
}
