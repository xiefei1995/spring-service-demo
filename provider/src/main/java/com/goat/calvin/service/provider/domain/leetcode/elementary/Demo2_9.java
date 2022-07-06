package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/1 13:30
 */
public class Demo2_9 {

	/**
	 * 编写一个函数来查找字符串数组中的最长公共前缀。
	 * 如果不存在公共前缀，返回空字符串 ""。
	 */

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 1) {
			return strs[0];
		}
		int left = 0;
		int right = strs.length - 1;
		int index = 0;
		StringBuilder sb = new StringBuilder();
		while (true) {
			if ("".equals(strs[left]) || "".equals(strs[right])) {
				return "";
			}
			if (strs[left].length() < index + 1 || strs[right].length() < index + 1) {
				return sb.toString();
			}
			if (strs[left].charAt(index) != strs[right].charAt(index)) {
				return sb.toString();
			}
			if (left >= right) {
				if (strs[left].charAt(index) != strs[left - 1].charAt(index)) {
					return sb.toString();
				}
				sb.append(strs[left].charAt(index));
				left = -1;
				right = strs.length;
				index++;
			}
			left++;
			right--;
		}
	}

	public static String longestCommonPrefixs(String[] strs) {
		//边界条件判断
		if (strs == null || strs.length == 0)
			return "";
		//默认第一个字符串是他们的公共前缀
		String pre = strs[0];
		int i = 1;
		while (i < strs.length) {
			//不断的截取：直到获取到最后的值
			while (strs[i].indexOf(pre) != 0)
				pre = pre.substring(0, pre.length() - 1);
			i++;
		}
		return pre;
	}

	public static void main(String[] args) {
		String[] strs = {"c"};
		System.out.println(longestCommonPrefix(strs));
	}

}
