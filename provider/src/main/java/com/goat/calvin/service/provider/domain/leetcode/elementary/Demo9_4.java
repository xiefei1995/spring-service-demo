package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/7/13 15:05
 */
public class Demo9_4 {

	/**
	 * 杨辉三角
	 * <p>
	 * 输入: numRows = 5
	 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
	 */
	public List<List<Integer>> generate(int numRows) {
		//结果值
		List<List<Integer>> res = new ArrayList<>();
		//每一行的元素
		ArrayList<Integer> row = new ArrayList<>();
		//注意点下标从1开始
		for (int i = 1; i <= numRows; i++) {
			row.add(0, 1);
			// 注意这是处理除了第一个和最后一个的判断
			for (int j = 1; j < i - 1; j++) {
				row.set(j, row.get(j) + row.get(j + 1));
			}
			res.add(new ArrayList<>(row));
		}
		return res;
	}

}