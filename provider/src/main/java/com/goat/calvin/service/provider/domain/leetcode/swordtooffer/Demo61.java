package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/4/14 9:12
 */
public class Demo61 {

    /**
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     *
     * 思路：最大和最小值之差是否小于5
     */

    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[zeroCount] < 5;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0};
        System.out.println(isStraight(nums));
    }
}
