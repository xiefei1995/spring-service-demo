package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/4/24 9:40
 */
public class Demo42 {
    /**
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
     * 求所有子数组的和的最大值。
     * 要求时间复杂度为O(n)。
     */

    public static int maxSubArray(int[] nums) {
        int pre = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            res = Math.max(pre, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2};
        System.out.println(maxSubArray(nums));
    }

}
