package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xiefei
 * @date 2022/7/13 15:52
 */
public class Demo9_5 {
	/**
	 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
	 * <p>
	 * 有效字符串需满足：
	 * <p>
	 * 左括号必须用相同类型的右括号闭合。
	 * 左括号必须以正确的顺序闭合。
	 */
	public static boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>(16);
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');
		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (c == ']' || c == '}' || c == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				Character pop = stack.pop();
				if (!pop.equals(map.get(c))) return false;
			}else{
				stack.add(c);
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		isValid("()");
	}
}
