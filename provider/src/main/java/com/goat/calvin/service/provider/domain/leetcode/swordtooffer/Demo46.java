package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/4/15 8:58
 */
public class Demo46 {

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，
     * 1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * <p>
     * 思路：找dp，该题主要是找到出口，同时要考虑到dp的最小值
     */

    public static int translateNum(int num) {
        String str = String.valueOf(num);
        int length = str.length();
        if (length < 2) {
            return length;
        }

        char[] chars = str.toCharArray();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < length; i++) {
            // 下一个数的解法至少是前一个数解法
            dp[i + 1] = dp[i];
            // 获取组合的数字
            int number = (chars[i - 1] - '0') * 10 + chars[i] - '0';
            if (number > 9 && number < 26) {
                dp[i + 1] = dp[i] + dp[i - 1];
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(25));
    }

    public static int translateNum2(int num) {
        String s = String.valueOf(num);
        if (s.length() < 2) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < chars.length; i++) {
            // 长度加一至少是当前的个数
            dp[i + 1] = dp[i];
            int temp = ((chars[i - 1] - '0') * 10 + chars[i] - '0');
            if (9 < temp && temp < 26) {
                dp[i + 1] = dp[i] + dp[i - 1];
            }
        }
        return dp[chars.length];
    }

}
