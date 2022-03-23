package com.goat.calvin.service.provider.domain.leetcode;

/**
 * @author xiefei
 * @date 2022/3/23 9:04
 */
public class Demo021 {


    /**
     * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 思路：快慢指针
        ListNode fNode = head;
        ListNode sNode = head;
        // 找到快指针起始点
        // 倒数第n个就是比他快n个
        // 快指针走完了，慢指针才走到倒数第n个
        for (int i = 0; i < n ; i++) {
            fNode = fNode.next;
        }
        if(fNode == null){
            return head.next;
        }
        while(fNode.next != null){
            fNode = fNode.next;
            sNode = sNode.next;
        }
        // 移除倒数第n个元素
        sNode.next = sNode.next.next;
        return head;
    }

    public static void main(String[] args) {
        //ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode node = new ListNode(1, new ListNode(2));
        removeNthFromEnd(node, 2);
    }
}
