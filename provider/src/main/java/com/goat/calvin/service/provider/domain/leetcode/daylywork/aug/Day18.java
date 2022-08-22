package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

import java.util.HashMap;
import java.util.Map;

/**
 * @author：xiefeiyf
 * @date：2022/8/18 : 9:35
 */
public class Day18 {
    /**
     * 给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度：
     * <p>
     * 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。
     * 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。
     */
    public int maxEqualFreq(int[] nums) {
        int length = (int) 1e5 + 7;
        // 定义hash表
        int[] hash = new int[length];
        // 频率
        int maxFreq = 0;
        // 数字的最大出现次数
        int maxSpecies = 0;
        // 数字种类：112223 = 3种
        int species = 0;
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            // 首次出现的数字加入hash表中
            if (hash[num]++ == 0) {
                species++;
            }
            if (hash[num] > maxFreq) {
                maxFreq = hash[num];
                maxSpecies = 1;
            } else if (hash[num] == maxFreq) {
                maxSpecies++;
            }
            if (maxFreq == 1 || maxFreq * maxSpecies == i || maxSpecies == 1 && maxFreq == i / species + 1) {
                ans = i + 1;
            }
        }
        return ans;
    }

}
