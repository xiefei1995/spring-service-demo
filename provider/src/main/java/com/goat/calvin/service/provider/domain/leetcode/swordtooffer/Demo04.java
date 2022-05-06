package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/4/11 9:14
 */
public class Demo04 {

    /**
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     * 思路：从每一行的最后一个数字开始找
     */

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[i].length) {
            // 找到目标值
            if (matrix[i][j] == target) {
                return true;
            }
            // 比目标值小，找下一行
            if (matrix[i][j] < target) {
                j++;
            } else {
                // 比目标值大，同一行的前一列
                i--;
            }
        }
        return false;
    }
}
