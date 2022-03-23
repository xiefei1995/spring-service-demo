package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/3/23 10:41
 */
public class Demo68 {

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
     * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
     * （一个节点也可以是它自己的祖先）。”
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 找寻的最近的公共祖先
        // 出口就是有一个node的值 = p 或者 q
        // 利用二叉树的左小右大的特性
        TreeNode res = root;
        while (true) {
            if (p.val < res.val && q.val < res.val) {
                res = res.left;
            } else if (p.val > res.val && q.val > res.val) {
                res = res.right;
            } else {
                // 如果一个比左边大，一个比右边小那就一定是根节点为最小公共节点了
                break;
            }
        }
        return res;
    }
}
