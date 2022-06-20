package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.List;

/**
 * @author xiefei
 * @date 2022/5/31 15:48
 */
public class Demo25 {

    // 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // 定义一个返回值以及和返回值一直的use node
        ListNode result = new ListNode(0);
        ListNode node = result;
        while (l1 != null && l2 != null) {
            // 找出最小的,并将其放在第一位
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            // result换下一个位置的值
            node = node.next;
        }
        node.next = l1 == null ? l2 : l1;
        return result.next;
    }

}
