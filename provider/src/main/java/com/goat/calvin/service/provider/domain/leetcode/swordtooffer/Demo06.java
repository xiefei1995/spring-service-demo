package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/5/5 9:16
 */
public class Demo06 {

    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        int[] result = new int[size];
        while (head != null) {
            result[size - 1] = head.val;
            head = head.next;
            size--;
        }
        return result;
    }
}
