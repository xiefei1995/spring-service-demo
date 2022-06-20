package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/6/7 11:07
 */
public class Demo34 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
     * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     * <p>
     * 思路：递归 + 剪枝
     */

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return res;
    }


    /**
     * 剪枝方法：剪枝就是减他的路径
     */
    public void recur(TreeNode node, int residue) {
        if (node == null) return;
        // 剩余
        residue = residue - node.val;
        // 路径
        path.add(node.val);
        // 特别注意这里是根节点到叶子节点的和
        if (residue == 0 && node.left == null && node.right == null) {
            // 将当前path复制一份并添加到返回值中
            res.add(new LinkedList<>(path));
        }
        // 左子树查询
        recur(node.left, residue);
        // 右子树查询
        recur(node.right, residue);
        // 剪枝,移除末尾数据
        path.removeLast();
    }

}