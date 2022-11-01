package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author：xiefeiyf
 * @date：2022/8/8 : 9:57
 */
public class Day8 {
    public String makeLargestSpecial(String s) {
        if (s.length() == 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        int count = 0, last = 0;
        for (int i = 0, cur = 0; i < s.length(); i++, cur++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }
            //一组有效的括号匹配 去掉括号进行 内部排序
            if (count == 0) {
                String str = "1" + makeLargestSpecial(s.substring(last + 1, cur)) + "0";
                list.add(str);
                last = cur + 1;
            }
        }
        //进行排序，根据冒泡排序，交换两个相邻的元素进行排序，总能让内部的括号由大到小排列
        list.sort(Comparator.reverseOrder());
        //拼成完整的字符串
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }

}
