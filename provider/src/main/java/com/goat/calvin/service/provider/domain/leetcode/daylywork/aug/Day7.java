package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author：xiefeiyf
 * @date：2022/8/8 : 10:08
 */
public class Day7 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> d = new ArrayDeque<>();
        int cur = -1;
        for (String log : logs) {
            String[] ss = log.split(":");
            int idx = Integer.parseInt(ss[0]), ts = Integer.parseInt(ss[2]);
            if (ss[1].equals("start")) {
                // 计算每一个的执行时长，尾插法
                if (!d.isEmpty()) ans[d.peekLast()] += ts - cur;
                d.addLast(idx);
                cur = ts;
            } else {
                int func = d.pollLast();
                ans[func] += ts - cur + 1;
                cur = ts + 1;
            }
        }
        return ans;
    }
}
