package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xiefei
 * @date 2022/6/2 13:43
 */
public class Demo32_3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
     * 二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     * <p>
     * <p>
     * 思路 :  1. 树做排序，安装左 -> 右 -> 左的顺序添加
     *        2. 树不做排序，每次都是左 -> 右 ，取数的时候排序，做顺序和倒序处理
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        // flag表示奇数层,数据从做到右
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                // res的size表示多少层
                if (res.size() % 2 == 0) {
                    // 偶数层。顺序排放，注意层数从0开始
                    list.addLast(poll.val);
                } else {
                    // 奇数层。倒序排放
                    list.addFirst(poll.val);
                }
                // 树放在队列里面的数据不变
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            res.add(list);
        }
        return res;
    }
}
