package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/3/31 10:44
 */
public class Demo36 {

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
     * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
     *
     * 思路：采用二叉树的中序遍历（数据有序且从小到大），再加上pre 和 next的指针
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

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    void dfs(Node cur) {
        if (null == cur) {
            return;
        }
        dfs(cur.left);
        // 如果前置节点为空那说明该节点就是头部节点
        if (null != pre) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        // 将下一个节点的头部节点设置为当前节点
        pre = cur;
        dfs(cur.right);
    }
}
