package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/6 12:30
 */
public class Demo4_5 {
	/**
	 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
	 * <p>
	 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
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

	public TreeNode sortedArrayToBST(int[] nums) {
		// 平衡二叉树,递归求每个节点
		if (nums.length == 0) return new TreeNode();
		return createNode(nums, 0, nums.length - 1);
	}

	public TreeNode createNode(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int rootIndex = (end + start) >> 1;
		TreeNode node = new TreeNode(nums[rootIndex]);
		// 每次用三个值
		node.left = createNode(nums, start, rootIndex - 1);
		node.right = createNode(nums, rootIndex + 1, end);
		return node;
	}

	public static void main(String[] args) {
		System.out.println(4 >> 1);
	}
}
