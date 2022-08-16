package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：xiefeiyf
 * @date：2022/8/11 : 10:57
 */
public class Demo11 {

    /**
     * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
     * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
     * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
     */
    public static String reformat(String s) {
        List<Character> list = new ArrayList<>(s.length());
        int numCount = 0;
        int letterCount = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 0;
            if (num > 96) {
                list.add(s.charAt(i));
                letterCount++;
            } else {
                list.add(numCount, s.charAt(i));
                numCount++;
            }
        }
        if (Math.abs(numCount - letterCount) > 1) return "";
        int left = 0;
        int right = list.size() - 1;
        StringBuilder sb = new StringBuilder();
        while (left < right) {
            if (numCount > letterCount) {
                sb.append(list.get(left));
                sb.append(list.get(right));
            } else {
                sb.append(list.get(right));
                sb.append(list.get(left));
            }
            left++;
            right--;
        }
        if (left == right) sb.append(list.get(left));
        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "j";
        System.out.println(reformat(s));

    }
}
