package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author xiefei
 * @date 2022/6/30 16:44
 */
public class Demo2_3 {

	/**
	 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
	 */
	public int firstUniqChar(String s) {
		Queue<Character> queue = new ArrayDeque<>();
		char[] used = new char[26];
		for (int i = 0; i < s.length(); i++) {
			if (queue.contains(s.charAt(i))) {
				queue.remove(s.charAt(i));
			} else if (used[s.charAt(i) - 'a'] != 1) {
				queue.add(s.charAt(i));
				used[s.charAt(i) - 'a'] = 1;
			}
		}
		Character poll = queue.poll();
		if (poll == null) return -1;
		return s.indexOf(poll);
	}


}
