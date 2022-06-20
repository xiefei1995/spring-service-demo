package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/5/31 16:30
 */
public class Demo28 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return check(root.left, root.right);
    }


    public boolean check(TreeNode left, TreeNode right) {
        // 空指针判断 , dfs只考虑一层，不用想太多层
        if (left == null && right == null) {
            return true;
        }
        // 其中有一个子树为null
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && check(left.left, right.right) && check(left.right, right.left);
    }

}
