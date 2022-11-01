package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author：xiefeiyf
 * @date：2022/8/12 : 9:42
 */
public class Demo12 {
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int num = groupSizes[i];
            if (map.containsKey(num)) {
                List<Integer> list = map.get(num);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num, list);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        map.forEach((k, v) -> {
            if (k >= v.size()) {
                res.add(v);
            } else {
                List<Integer> l = new ArrayList<>(k);
                for (int i = 0; i < v.size(); i++) {
                    if (l.size() == k) {
                        res.add(l);
                        l = new ArrayList<>();
                        l.add(v.get(i));
                    } else {
                        l.add(v.get(i));
                    }
                }
                res.add(l);
            }
        });
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,3,3,2};
        System.out.println(groupThePeople(nums));
    }
}
