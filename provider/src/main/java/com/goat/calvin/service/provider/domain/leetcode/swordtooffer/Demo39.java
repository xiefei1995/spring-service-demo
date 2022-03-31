package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/3/24 10:39
 */
public class Demo39 {

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int half = nums.length / 2;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            length++;
            if (length > half) {
                return nums[i];
            }
            if (nums[i] != nums[i + 1]) {
                length = 0;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(majorityElement(nums));
    }
}
