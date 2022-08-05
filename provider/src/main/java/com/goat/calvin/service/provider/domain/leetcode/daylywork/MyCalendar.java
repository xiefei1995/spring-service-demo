package com.goat.calvin.service.provider.domain.leetcode.daylywork;

/**
 * @author xiefei
 * @date 2022/7/5 11:04
 */
public class MyCalendar {
	/**
	 * 二叉树辅助
	 */
	static class TreeNode {
		private TreeNode left;
		private TreeNode right;
		private int start;
		private int end;

		public TreeNode(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	static TreeNode root;

	public MyCalendar() {

	}

	public static boolean book(int start, int end) {
		if (root == null) {
			root = new TreeNode(start, end);
			return true;
		}
		// 左子树比较
		TreeNode cur = root;
		while(true){
			if (end <= cur.start) {
				if (cur.left == null) {
					cur.left = new TreeNode(start, end);
					return true;
				}
				cur = cur.left;
				// 右子树比较
			} else if (start >= cur.end) {
				if (cur.right == null) {
					cur.right = new TreeNode(start, end);
					return true;
				}
				cur = cur.right;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		MyCalendar myCalendar = new MyCalendar();
		System.out.println(myCalendar.book(10, 20));
		System.out.println(myCalendar.book(0, 5));
		System.out.println(myCalendar.book(20, 30));
	}
}
