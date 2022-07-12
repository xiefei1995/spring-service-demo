package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/7/7 14:59
 */
public class Demo6_4 {

	private static int res;

	/**
	 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
	 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
	 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
	 * 给定一个代表每个房屋存放金额的非负整数数组，
	 * 计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
	 */

	public static int rob(int[] nums) {
		// 第一家投偷了和第一家没偷
		int dp0 = 0;
		int dp1 = nums[0];
		//从第2个开始判断
		for (int i = 1; i < nums.length; i++) {
			//防止dp0被修改之后对下面运算造成影响，这里
			//使用一个临时变量temp先把结果存起来，计算完
			//之后再赋值给dp0.
			int temp = Math.max(dp0, dp1);
			// dp1始终是在原来的dp0基础上多拿一个
			dp1 = dp0 + nums[i];
			dp0 = temp;
		}
		//最后取最大值即可
		return Math.max(dp0, dp1);
	}
}
