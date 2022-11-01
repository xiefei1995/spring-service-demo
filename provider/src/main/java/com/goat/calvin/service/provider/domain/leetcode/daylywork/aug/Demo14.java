package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

/**
 * @author：xiefeiyf
 * @date：2022/8/15 : 9:35
 */
public class Demo14 {
    public static int maxScore(String s) {
        int leftScore = s.charAt(0) == '0' ? 1 : 0;
        int rightScore = 0;
        for (int i = 1; i < s.length(); i++) {
            if ('1' == s.charAt(i)) rightScore++;
        }
        int sum = rightScore + leftScore;
        for (int i = 1; i < s.length() - 1; i++) {
            if ('1' == s.charAt(i)) {
                rightScore--;
                if (rightScore < 0) rightScore = 0;
            } else leftScore++;
            if (leftScore + rightScore > sum) sum = leftScore + rightScore;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "000000000";
        System.out.println(maxScore(s));
    }
}
