package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;


import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/3/31 9:28
 */
public class Demo32 {
    /**
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * <p>
     * 思路：找到每一层的节点再去找下一层的
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list = new ArrayList<>();

    public int[] levelOrder(TreeNode root) {
        List<TreeNode> rootList = new ArrayList<>();
        rootList.add(root);
        getOrder(rootList);
        int[] res = new int[list.size()];
        if (list.size() == 0) return res;
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void getOrder(List<TreeNode> nodes) {
        List<TreeNode> res = new ArrayList<>(nodes.size() * 2);
        if (nodes == null || nodes.size() == 0) {
            return;
        }
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode treeNode = nodes.get(i);
            if (treeNode != null) {
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    res.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    res.add(treeNode.right);
                }
            }
        }
        getOrder(res);
    }

}
