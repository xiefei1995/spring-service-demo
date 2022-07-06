package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/5 13:29
 */
public class Demo4_2 {

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
	 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
	 * 有效 二叉搜索树定义如下：
	 * 节点的左子树只包含 小于 当前节点的数。
	 * 节点的右子树只包含 大于 当前节点的数。
	 * 所有左子树和右子树自身必须也是二叉搜索树。
	 */

	public boolean isValidBST(TreeNode root) {
		return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean check(TreeNode root, long minVal, long maxVal) {
		// 空节点默认为二叉搜索树
		if (root == null) return true;
		// 如果root的值不再min - max的范围内直接返回false
		if (root.val >= maxVal || root.val <= minVal) return false;
		// 左右子树分别校验:左子树不能比root值大，右子树不能比root值小
		return check(root.left, minVal, root.val) && check(root.right, root.val, maxVal);
	}
}
