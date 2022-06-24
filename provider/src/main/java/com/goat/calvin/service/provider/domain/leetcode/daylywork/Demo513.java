package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

/**
 * @author xiefei
 * @date 2022/6/23 9:00
 */
public class Demo513 {

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

	public int findBottomLeftValue(TreeNode root) {
		// 一层一层找,一层找完再找下一层
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.addLast(root);
		int res = 0;
		// 队列不为空时
		while (!deque.isEmpty()) {
			int size = deque.size();
			// 拿最左边的数据
			res = deque.peek().val;
			while (size-- > 0) {
				// 从左到右处理
				TreeNode first = deque.pollFirst();
				if (first.left != null) deque.addLast(first.left);
				if (first.right != null) deque.addLast(first.right);
			}
		}
		return res;
	}

}
