package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/6/21 10:40
 */
public class Demo52 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 走圈问题,将单联的listNode模拟成一个环线的，找第一次相遇
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2){
            node1 = node1 == null ? headA : node1.next;
            node2 = node2 == null ? headB : node2.next;
        }
        return node1;
    }

}
