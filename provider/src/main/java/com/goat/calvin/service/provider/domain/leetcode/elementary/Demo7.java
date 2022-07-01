package com.goat.calvin.service.provider.domain.leetcode.elementary;

import com.google.inject.internal.cglib.proxy.$Dispatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/6/28 13:31
 */
public class Demo7 {

	/**
	 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
	 * <p>
	 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
	 * <p>
	 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
	 */

	public int[] plusOne(int[] digits) {
		// 123
		List<Integer> list = new ArrayList<>();
		int relation = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			int temp = digits[i] + relation;
			if (i == digits.length - 1) {
				temp += 1;
			}
			list.add(temp % 10);
			relation = temp / 10;
		}
		if (relation != 0) list.add(relation);
		int[] res = new int[list.size()];
		int index = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			res[index++] = list.get(i);
		}
		return res;
	}
}
