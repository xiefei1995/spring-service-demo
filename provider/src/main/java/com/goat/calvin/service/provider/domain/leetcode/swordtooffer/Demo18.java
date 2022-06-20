package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/5/30 10:03
 */
public class Demo18 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode pre = head;
        ListNode cur = head.next;
        // 找到需要删除的cur
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        // 删除cur Node
        if(cur != null) pre.next = cur.next;
        return head;
    }
}
