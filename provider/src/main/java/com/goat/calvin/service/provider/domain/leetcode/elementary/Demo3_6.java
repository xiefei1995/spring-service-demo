package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/5 10:33
 */
public class Demo3_6 {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * 思路是快慢指针相遇点,走圈问题
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) return false;
		ListNode fast = head;
		ListNode slow = head;
		boolean flag = false;
		while (fast.next != null && slow != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				flag = true;
				break;
			}
		}
		while (head != null && slow != null) {
			if (head == slow) {
				// 找到相遇点
			}
			head = head.next;
			slow = slow.next;
		}
		return flag;
	}
}
