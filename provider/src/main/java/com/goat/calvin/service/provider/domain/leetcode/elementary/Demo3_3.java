package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/4 19:26
 */
public class Demo3_3 {

	/**
	 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
	 */
	public class ListNode {
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

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null;
		while (head != null) {
			ListNode temp = head;
			head = head.next;
			temp.next = pre;
			pre = temp;
		}
		return pre;
	}

}
