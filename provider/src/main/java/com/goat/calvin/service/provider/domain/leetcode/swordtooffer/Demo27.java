package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/4/18 9:07
 */
public class Demo27 {
    /**
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            mirrorTree(left);
            mirrorTree(right);
        }
        return root;
    }

}
