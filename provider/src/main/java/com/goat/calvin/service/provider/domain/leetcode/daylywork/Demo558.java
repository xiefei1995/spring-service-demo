package com.goat.calvin.service.provider.domain.leetcode.daylywork;

/**
 * @author xiefei
 * @date 2022/7/15 9:28
 */
public class Demo558 {
	class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;

		public Node() {
		}

		public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
			val = _val;
			isLeaf = _isLeaf;
			topLeft = _topLeft;
			topRight = _topRight;
			bottomLeft = _bottomLeft;
			bottomRight = _bottomRight;
		}
	}

	public Node intersect(Node quadTree1, Node quadTree2) {
		// 都为true -> true，返回t1或者t2的true值，如果都为false返回任意一个
		if (quadTree1.isLeaf && quadTree2.isLeaf) {
			if (quadTree1.val) return quadTree1;
			else if (quadTree2.val) return quadTree2;
			else return quadTree1;
		}
		Node ans = new Node();
		// 如果isLeaf为true说明其自己都是true或者false，则可跳过子集比对，反之则比对子象限
		ans.topLeft = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.topLeft, quadTree2.isLeaf ? quadTree2 : quadTree2.topLeft);
		ans.topRight = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.topRight, quadTree2.isLeaf ? quadTree2 : quadTree2.topRight);
		ans.bottomLeft = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomLeft, quadTree2.isLeaf ? quadTree2 : quadTree2.bottomLeft);
		ans.bottomRight = intersect(quadTree1.isLeaf ? quadTree1 : quadTree1.bottomRight, quadTree2.isLeaf ? quadTree2 : quadTree2.bottomRight);
		// 如果四个象限的isLeft都为true -> a = true
		boolean a = ans.topLeft.isLeaf && ans.topRight.isLeaf && ans.bottomLeft.isLeaf && ans.bottomRight.isLeaf;
		// 四个象限的值都为true
		boolean b = ans.topLeft.val && ans.topRight.val && ans.bottomLeft.val && ans.bottomRight.val;
		// 四个象限其中一个值为true
		boolean c = ans.topLeft.val || ans.topRight.val || ans.bottomLeft.val || ans.bottomRight.val;
		// 因为left、right都为false时isLeaf也为true
		ans.isLeaf = a && (b || !c);
		ans.val = ans.topLeft.val;
		if (ans.isLeaf) ans.topLeft = ans.topRight = ans.bottomLeft = ans.bottomRight = null;
		return ans;
	}

	public static void main(String[] args) {
	}

}
