package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/4 19:31
 */
public class Demo3_4 {

	/**
	 * 将两个升序链表合并为一个新的 升序 链表并返回。
	 * 新链表是通过拼接给定的两个链表的所有节点组成的。
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

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode listNode = new ListNode();
		ListNode res = listNode;
		while (list1 != null || list2 != null) {
			if (list1 == null) {
				listNode.next = list2;
				break;
			}
			if (list2 == null) {
				listNode.next = list1;
				break;
			}
			if (list1.val <= list2.val) {
				listNode.next = list1;
				list1 = list1.next;
			} else {
				listNode.next = list2;
				list2 = list2.next;
			}
			// 移动节点的位置
			listNode = listNode.next;
		}
		return res.next;
	}
}
