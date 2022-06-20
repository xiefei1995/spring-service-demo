package com.goat.calvin.service.provider.domain.leetcode.StringAndNums;

/**
 * @author xiefei
 * @date 2022/5/16 9:12
 */
public class Demo2 {
    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * <p>
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * <p>
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * <p>
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     */

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 == (sum - nums[i])) {
                return i;
            } else {
                leftSum += nums[i];
            }
            System.out.println(leftSum);
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {-1,1,0,-1,1,0};
        int i = pivotIndex(nums);
        System.out.println(i);

    }
}
