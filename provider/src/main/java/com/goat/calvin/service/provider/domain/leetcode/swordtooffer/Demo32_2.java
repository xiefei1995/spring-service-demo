package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * @author xiefei
 * @date 2022/6/1 15:18
 */
public class Demo32_2 {
    /**
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    List<List<Integer>> list = new ArrayList<>();

    List<List<TreeNode>> treeNodes = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<TreeNode> roots = new ArrayList<>();
        roots.add(root);
        getOrder(roots);
        for (int i = 0; i < treeNodes.size(); i++) {
            // 获取每一层node的val
            List<Integer> l1 = new ArrayList<>();
            List<TreeNode> t1 = this.treeNodes.get(i);
            for (int j = 0; j < t1.size(); j++) {
                l1.add(t1.get(j).val);
            }
            list.add(l1);
        }
        return list;
    }


    // 解题思路，每次传递每一层的所有节点
    public void getOrder(List<TreeNode> nodes) {
        if (nodes.size() == 0) return;
        List<Integer> valList = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            valList.add(nodes.get(i).val);
        }
        list.add(valList);
        treeNodes.add(nodes);
        List<TreeNode> next = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).left != null) {
                next.add(nodes.get(i).left);
            }
            if (nodes.get(i).right != null) {
                next.add(nodes.get(i).right);
            }
        }
        getOrder(next);
    }


    // 使用队列先进先出的特性
    public List<List<Integer>> getOrder2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> son = new ArrayList<>();
            // 将每一层的数据放入到queue中，每一次只处理上一次放入的数据的个数
            // 一次queued的循环就是一层数据
            for (int i = queue.size() - 1; i > 0; i--) {
                TreeNode poll = queue.poll();
                son.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }

            res.add(son);
        }
        return res;
    }
}
