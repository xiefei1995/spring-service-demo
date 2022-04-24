package com.goat.calvin.service.provider.domain.leetcode.daylywork;

/**
 * @author xiefei
 * @date 2022/4/7 9:04
 */
public class Demo36 {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
     * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
     * <p>
     * 思路就是head、tail节点，节点转移，类似aqs入队中的casHead、casTail
     */
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    // 头结点
    Node head = null;
    // 尾节点
    Node tail = null;

    public Node treeToDoublyList(Node root) {
        if (null == root) return null;
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    /**
     * 非常类似aqs入队的代码，二叉树的中序遍历
     */
    public void dfs(Node node) {
        if (node == null) return;
        // 1.先将左边的全部排序
        dfs(node.left);
        // 尾节点为null说明为链表为null
        if (tail == null) {
            head = node;
        } else {
            tail.right = node;
        }
        node.left = tail;
        // 尾节点转移
        tail = node;
        // 2.再做右边的排序
        dfs(node.right);
    }
}
