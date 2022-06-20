package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author xiefei
 * @date 2022/6/8 14:14
 */
public class Demo35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
     * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random
     * 指针指向链表中的任意节点或者 null。
     * <p>
     * 思路：next指的是node，random指的是坐标
     */

    public Node copyRandomList(Node head) {
        // 获取当前树的random节点
        Map<Node, Node> randomMap = new HashMap<>(16);
        Node pre = head;
        Node cur = head;
        // 将当前节点建立一个random、next都为空的节点
        while (pre != null) {
            randomMap.put(pre, new Node(pre.val));
            pre = pre.next;
        }
        while (cur != null) {
            // 设置next节点
            randomMap.get(cur).next = randomMap.get(cur.next);
            // 设置next节点的random节点
            randomMap.get(cur).random = randomMap.get(cur.random);
            cur = cur.next;
        }
        return randomMap.get(head);
    }
}
