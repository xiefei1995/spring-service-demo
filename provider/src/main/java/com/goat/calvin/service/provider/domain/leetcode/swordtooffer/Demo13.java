package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/5/26 9:03
 */
public class Demo13 {

    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
     * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
     * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
     * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     */


    public static int movingCount(int m, int n, int k) {
        boolean[][] used = new boolean[m][n];
        return mCount(0,0,k,used);
    }

    public static int mCount(int m, int n, int k, boolean[][] used) {
        int sum = m / 10 + m % 10 + n / 10 + n % 10;
        if (m < 0 || m >= used.length || n < 0 || n >= used[0].length || used[m][n] || sum > k) {
            return 0;
        }
        used[m][n] = true;
        return 1 + mCount(m - 1, n, k, used) + mCount(m + 1, n, k, used) + mCount(m, n - 1, k, used) + mCount(m, n + 1, k, used);
    }

    public static void main(String[] args) {
        int count = movingCount(3, 1, 0);
        System.out.println(count);
    }

}
