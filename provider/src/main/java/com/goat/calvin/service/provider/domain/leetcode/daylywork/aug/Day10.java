package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：xiefeiyf
 * @date：2022/8/10 : 9:38
 */
public class Day10 {

    /**
     * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
     * <p>
     * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
     * <p>
     * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
     */

    static final String NO_SOLUTION = "No_solution";
    static final String INFINITE_SOLUTION = "Infinite_solution";

    static int lxCount = 0;
    static int lsum = 0;
    static int rxCount = 0;
    static int rsum = 0;

    public static String solveEquation(String equation) {
        String[] split = equation.split("=");
        String left = split[0];
        String right = split[1];
        // string相同指定只有一个解法
        if (left.equals(right)) return INFINITE_SOLUTION;
        // 计算左边的值
        extracted(left, true);
        extracted(right, false);
        // 计算左右两边的值
        int i = lxCount - rxCount;
        int j = rsum - lsum;
        if (i == 0 && j == 0) return INFINITE_SOLUTION;
        else if (i == 0 && j != 0) return NO_SOLUTION;
        else if (j == 0) return "x=0";
        else return "x=" + j / i;
    }

    private static void extracted(String str, boolean flag) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (i != 0 && !Character.isLetterOrDigit(chars[i])) {
                String num = sb.toString();
                extracted(flag, num);
                sb = new StringBuilder("");
            }
            sb.append(chars[i]);
        }
        extracted(flag, sb.toString());
    }

    private static void extracted(boolean flag, String num) {
        if (num.contains("x")) {
            // 左边
            String leftStr = num.replace("x", "");
            if ("+".equals(leftStr) || "-".equals(leftStr)) leftStr += "1";
            int r = "".equals(leftStr) ? 1 : Integer.parseInt(leftStr);
            if (flag) lxCount += r;
            else rxCount += r;
        } else {
            // 左边
            if (!"".equals(num)) {
                if (flag) lsum += Integer.parseInt(num);
                else rsum += Integer.parseInt(num);
            }
        }
    }

    public static void main(String[] args) {
        //System.out.println(Integer.parseInt("-2"));
        System.out.println(solveEquation("2+2-x+x+3x=x+2x-x+x+4"));
    }
}
