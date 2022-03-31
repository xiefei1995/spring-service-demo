package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/3/24 11:01
 */
public class Demo55 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 题目要求每一个节点都是平衡的
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        return Math.abs(deep(root.left) - deep(root.right)) < 1;
    }


    // 二叉树的高度dp公式：dp[parent] = Math.nax(dp[sonLeft],dp[sonRight]) + 1;
    public int deep(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(deep(node.left), deep(node.right)) + 1;
    }
}
