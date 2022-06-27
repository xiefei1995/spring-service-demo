package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiefei
 * @date 2022/6/24 9:59
 */
public class Demo515 {

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
	 * 利用队列先进先出特性
	 */
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) return res;
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int fMax = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				TreeNode poll = queue.poll();
				fMax = Math.max(poll.val, fMax);
				if (poll.left != null) queue.add(poll.left);
				if (poll.right != null) queue.add(poll.right);
			}
			res.add(fMax);
		}
		return res;
	}
}
