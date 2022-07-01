package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/6/30 14:57
 */
public class Demo2_01 {
	/**
	 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
	 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
	 */

	public void reverseString(char[] s) {
		char[] chars = Arrays.copyOf(s, s.length);
		int index = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			s[index++] = chars[i];
		}
	}

	public void reverseString2(char[] s) {
		// 反转，左右指针交换
		int left = 0;
		int right = s.length - 1;
		while (left < right) {
			char temp = s[left];
			s[left++] = s[right];
			s[right--] = temp;
		}
	}

}
