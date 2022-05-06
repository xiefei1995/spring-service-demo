package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import com.google.inject.internal.cglib.proxy.$FixedValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/4/24 10:17
 */
public class Demo26 {
    /**
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     * <p>
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<TreeNode> list;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        getTreeNode(A, B.val);
        if (null == list) return false;
        for (TreeNode node : list) {
            if (checkNode(node, B)) return true;
        }
        return false;
    }

    public void getTreeNode(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        if (node.val == val) {
            if (null == list) {
                list = new ArrayList<>();
            }
            list.add(node);
        }
        getTreeNode(node.left, val);
        getTreeNode(node.right, val);
    }


    public boolean checkNode(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        // 要考虑母树比子树多的情况
        if (A != null && B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return checkNode(A.left, B.left) && checkNode(A.right, B.right);
    }
}
