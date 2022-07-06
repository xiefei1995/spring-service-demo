package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/7/4 19:40
 */
public class Demo3_5 {

	/**
	 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
	 * 如果是，返回 true ；否则，返回 false 。
	 */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public boolean isPalindrome(ListNode head) {
		List<Integer> asc = new ArrayList<>();
		List<Integer> desc = new ArrayList<>();
		while (head != null) {
			asc.add(head.val);
			desc.add(0, head.val);
			head = head.next;
		}
		return asc.equals(desc);
	}
}
