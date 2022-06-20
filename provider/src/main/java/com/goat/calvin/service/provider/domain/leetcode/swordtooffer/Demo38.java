package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author xiefei
 * @date 2022/6/8 18:48
 */
public class Demo38 {

    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     * <p>
     * 思路：找每一个位置可能出现的值并将其拼凑出来
     */

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }


    public void dfs(int index) {
        if (index == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }

        // 定义一个set来装已经使用过的char
        Set<Character> used = new HashSet<>();
        for (int i = index; i < c.length; i++) {
            // 剪枝如果和这个值出现过就直接剪枝
            if (used.contains(c[i])) {
                continue;
            }
            used.add(c[i]);
            // 固定index位置的值,将index和当前位置替换
            swap(index, i);
            // 对下一个位置元素做同样的操作
            dfs(index + 1);
            // 还原最初位置
            swap(index, i);
        }

    }

    public void swap(int index, int i) {
        char temp = c[i];
        c[i] = c[index];
        c[index] = temp;
    }

}
