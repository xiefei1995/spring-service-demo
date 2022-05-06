package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xiefei
 * @date 2022/5/5 8:55
 */
public class Demo03 {
    /**
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。
     */

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            boolean add = set.add(num);
            if (!add) {
                return num;
            }
        }
        return 0;
    }
}
