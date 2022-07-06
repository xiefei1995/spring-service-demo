package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/4 16:42
 */
public class Demo3_1 {

	/**
	 * 请编写一个函数，用于 删除单链表中某个特定节点 。
	 * 在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
	 * 题目数据保证需要删除的节点 不是末尾节点 。
	 */

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
