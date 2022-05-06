package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiefei
 * @date 2022/5/4 14:43
 */
public class ZhaohangDemo1 {
    /**
     * 时间排序，秒在前，分在后，小时在最后
     */
    public ArrayList<String> timeSort(ArrayList<String> times) {
        if (null == times || times.size() == 0 || times.size() == 1) {
            return times;
        }
        ArrayList<String> reverts = new ArrayList<>(times.size());
        Map<String, String> map = new HashMap<>(times.size());
        for (String str : times) {
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = chars.length - 1; i >= 0; i--) {
                sb.append(chars[i]);
            }
            reverts.add(sb.toString());
            map.put(sb.toString(), str);
        }

        for (int i = 0; i < reverts.size() - 1; i++) {
            for (int j = i + 1; j < reverts.size(); j++) {
                if (reverts.get(i).compareTo(reverts.get(j)) > 0) {
                    String s = reverts.get(i);
                    reverts.set(i, reverts.get(j));
                    reverts.set(j, s);
                }
            }
        }

        ArrayList<String> result = new ArrayList<>(times.size());
        for (int i = 0; i < reverts.size(); i++) {
            result.add(map.get(reverts.get(i)));
        }
        return result;
    }

    public static boolean magicString(String s) {
        if (null == s) return false;
        while (s.contains("cm")) {
            s = s.replace("cm", "");
        }
        return "".equals(s);
    }

    public static void main(String[] args) {
    }
}
