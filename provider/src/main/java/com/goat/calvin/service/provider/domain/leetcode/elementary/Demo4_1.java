package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/5 13:26
 */
public class Demo4_1 {

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
	 * 思路：每走一层深度就是+1
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
