package com.goat.calvin.service.provider.domain.leetcode.daylywork;

/**
 * @author xiefei
 * @date 2022/7/21 15:15
 */
public class Demo814 {
	/**
	 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
	 * 返回移除了所有不包含 1 的子树的原二叉树。
	 * 节点 node 的子树为 node 本身加上所有 node 的后代。
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

	public TreeNode pruneTree(TreeNode root) {
		TreeNode check = check(root);
		return check;
	}

	public TreeNode check(TreeNode node) {
		if (node == null) {
			return null;
		}
		TreeNode treeNode = new TreeNode(node.val, null, null);
		if (node.left != null) {
			treeNode.left = (check(node.left));
		}
		if (node.right != null) {
			treeNode.right = check(node.right);
		}
		if (treeNode.left == null && treeNode.right == null && treeNode.val == 0) {
			treeNode = null;
		}
		return treeNode;
	}

}
