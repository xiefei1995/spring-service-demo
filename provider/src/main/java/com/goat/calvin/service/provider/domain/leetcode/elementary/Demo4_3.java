package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author xiefei
 * @date 2022/7/6 11:16
 */
public class Demo4_3 {
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

	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return check(root.left, root.right);
	}

	public boolean check(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		// 递归处理即可
		if (left == null || right == null || left.val != right.val) return false;
		return check(left.left, right.right) && check(left.right, right.left);
	}

}
