package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xiefei
 * @date 2022/4/25 8:47
 */
public class Demo49 {
    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     * <p>
     * 1 是丑数。
     * n 不超过1690。
     * <p>
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     */

    public static int nthUglyNumber(int n) {
        // 递增 + 指针
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            // 比较丑数的大小，将最小的丑数放入dp数组中
            dp[i] = Math.min(n2, Math.min(n3, n5));
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(294));
    }

}
