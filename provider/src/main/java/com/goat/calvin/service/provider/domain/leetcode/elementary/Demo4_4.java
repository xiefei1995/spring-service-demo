package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xiefei
 * @date 2022/7/6 12:21
 */
public class Demo4_4 {

	/**
	 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
	 */

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

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		// 注意之类最好用LinkedBlockingQueue
		BlockingQueue<TreeNode> queue = new LinkedBlockingQueue<>();
		queue.add(root);
		while (queue.size() > 0) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>(size);
			while (size > 0) {
				TreeNode poll = queue.poll();
				list.add(poll.val);
				if (poll.left != null) queue.add(poll.left);
				if (poll.right != null) queue.add(poll.right);
				size--;
			}
			res.add(list);
		}
		return res;
	}
}
