package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/4 17:29
 */
public class Demo3_2 {

	/**
	 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
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

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || head.next == null) {
			return null;
		}
		// 快慢指针
		ListNode res = head;
		ListNode temp = head;
		int index = 0;
		while (temp != null) {
			temp = temp.next;
			// 双指针，快指针走完，移除慢指针当前数字
			if (temp == null) {
				// 长度不够直接返回head.next
				if (index < n) {
					res = head.next;
				} else {
					// 1. 正常走完
					head.next = head.next.next;
				}
				break;
			}
			// 慢指针比快指针慢n步骤
			if (index >= n) {
				head = head.next;
			}
			index++;
		}
		return res;
	}
}
