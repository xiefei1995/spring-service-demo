package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/7/27 9:59
 */
public class Demo592 {

	/**
	 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
	 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，
	 * 你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。
	 */
	public static String fractionAddition(String expression) {
		// 先将数字默认为正数
		List<String> list = new ArrayList<>(expression.length());
		StringBuilder sb = new StringBuilder();
		// 先算出全部是正数的
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+') {
				list.add(sb.toString());
				sb = new StringBuilder();
				continue;
			}
			sb.append(expression.charAt(i));
		}
		list.add(sb.toString());
		// 切分负数的：PS第一个指定是正数
		String res = "0";
		for (String s : list) {
			if (s.contains("-")) {
				String[] split = s.split("-");
				for (int i = 0; i < split.length; i++) {
					// 有可能开头是-，截取下来的是“”,这种不计数
					if (i == 0) {
						if (!split[0].equals("")) res = add(res, split[0]);
					} else res = add(res, "-" + split[i]);
				}
				continue;
			}
			res = add(res, s);
		}
		if (!res.contains("/")) return res + "/1";
		return res;
	}

	// 求和
	public static String add(String a, String b) {
		if ("0".equals(a)) return b;
		String[] splitA = a.split("/");
		String[] splitB = b.split("/");
		int denominator = Integer.parseInt(splitB[1]) * Integer.parseInt(splitA[1]);
		int moleculeSum = Integer.parseInt(splitA[0]) * Integer.valueOf(splitB[1]) +
				Integer.parseInt(splitB[0]) * Integer.parseInt(splitA[1]);
		if (moleculeSum == 0) return "0";
		return maxCommon(moleculeSum, denominator);
	}

	// 最大公约数
	public static String maxCommon(int mole, int deno) {
		int[] nums = new int[2];
		nums[0] = mole;
		nums[1] = deno;
		int maxDemo = Math.min(Math.abs(mole), Math.abs(deno));
		for (int i = maxDemo; i >= 1; i--) {
			boolean flag = mole % i == 0 && mole / i != 0;
			boolean flag2 = deno % i == 0 && deno / i != 0;
			if (flag && flag2) {
				nums[0] = mole / i;
				nums[1] = deno / i;
				break;
			}
		}
		return nums[0] + "/" + nums[1];
	}

	public static void main(String[] args) {
		String s = fractionAddition("-1/4-4/5-1/4");
		System.out.println(s);
	}

}
