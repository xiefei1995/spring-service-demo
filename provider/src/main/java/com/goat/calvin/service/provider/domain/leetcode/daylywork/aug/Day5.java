package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author xiefei
 * @date 2022/8/5 9:19
 */
public class Day5 {

	public static class TreeNode {
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

	static Queue<TreeNode> queue = new LinkedBlockingQueue<>();

	public static TreeNode addOneRow(TreeNode root, int val, int depth) {
		if(depth == 1) return new TreeNode(1,root,null);
		queue.add(root);
		int index = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				TreeNode poll = queue.poll();
				if (index == depth - 1) {
					TreeNode left = poll.left;
					TreeNode right = poll.right;
					poll.left = new TreeNode(val,left,null);
					poll.right = new TreeNode(val,null,right);
				} else {
					if (poll.left != null) queue.add(poll.left);
					if (poll.right != null) queue.add(poll.right);
				}
				size--;
			}
			if (index == depth) break;
			index++;
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(4, new TreeNode(2, null, null), new TreeNode(6, null, null));
		addOneRow(node, 1, 1);
	}

}
