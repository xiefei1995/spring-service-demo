package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/6/6 11:29
 */
public class Demo33 {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
     * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
     *
     * 思路：后续问题是数组的最后一个元素一定是根
     */

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) return false;
        // 思路：最后一个元素肯定是跟节点
        return check(postorder, 0, postorder.length - 1);
    }

    public boolean check(int[] postOrder, int i, int j) {
        if (i >= j) {
            return true;
        }
        // 找根节点
        int p = i;
        // 左节点：比根小的都是左子树
        while (postOrder[p] < postOrder[j]) {
            p++;
        }
        // 设置m为根
        int m = p;
        // 右节点：比根大的都是右子树
        while (postOrder[p] > postOrder[j]) {
            p++;
        }
        // 如果p=j表示安装m为根能够将数据完全分为左子树和右子树，同时再对左子树和右子树校验
        return p == j && (check(postOrder, i, m - 1) && check(postOrder, m, j - 1));
    }


}
