package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/7/25 12:29
 */
public class CBTInserter {


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

	// 因为最终要返回head所以不用queue
	List<TreeNode> list = new ArrayList<>();
	int index = 0;

	public CBTInserter(TreeNode root) {
		list.add(root);
		int cur = 0;
		// 分解node。记录每一个node以及他的子node（BFS思想）
		while (cur < list.size()) {
			TreeNode treeNode = list.get(cur);
			// 先添加左后添加右保证顺序
			if (treeNode.left != null) list.add(treeNode.left);
			if (treeNode.right != null) list.add(treeNode.right);
			cur++;
		}
	}

	public int insert(int val) {
		TreeNode treeNode = new TreeNode(val);
		while (list.get(index).left != null && list.get(index).right != null) index++;
		// 找到没有left或者right
		if (list.get(index).left == null) list.get(index).left = treeNode;
		else if (list.get(index).right == null) list.get(index).right = treeNode;
		// 将新加入的node加入到list中
		list.add(treeNode);
		return list.get(index).val;
	}

	public TreeNode get_root() {
		return list.get(0);
	}
}
