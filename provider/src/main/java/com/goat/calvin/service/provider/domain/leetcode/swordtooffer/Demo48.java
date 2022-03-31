package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/3/24 9:14
 */
public class Demo48 {

    /**
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，
     * 计算该最长子字符串的长度。
     */

    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int length = 0;
        int res = 0;
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!chars.contains(s.charAt(i))) {
                chars.add(s.charAt(i));
                length++;
            } else {
                chars.clear();
                start = start + 1;
                i = start - 1;
                res = Math.max(res, length);
                length = 0;
            }
        }
        return Math.max(res, length);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
