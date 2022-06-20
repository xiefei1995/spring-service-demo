package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/3/23 11:11
 */
public class Demo47 {

    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     */


    public int maxValue(int[][] grid) {
        // 最后一个是确定的，只需要找前面一个最大的就ok
        int row = grid.length;
        int col = grid[0].length;
        // 将每一个点都算出来，不剪枝，最后直接取目标
        int[][] dp = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                // 因为坐标是从1开始，所以这里i相当于是下一个坐标，i-1才是当前坐标
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[row][col];
    }
}
