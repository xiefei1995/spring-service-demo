package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/6/21 15:04
 */
public class Demo54 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<Integer> list = new ArrayList<>();

	int res;
	int k;

	public int kthLargest(TreeNode root, int k) {
	    this.k = k;
        dfs(root);
        return res;
	}

	public void getVal(TreeNode node) {
		if (node == null) {
			return;
		}
		list.add(node.val);
		getVal(node.left);
		getVal(node.right);
	}

	/**
	 * 中序是顺序处理(先左子树再右子树),这里找的是第几大的就要反向中序
	 */
	public void dfs(TreeNode node) {
		if (node == null) return;
		dfs(node.right);
		if (k == 0) return;
		if (--k == 0){
		    res = node.val;
            return;
        }
		dfs(node.left);
	}

}
