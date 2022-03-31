package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/3/23 17:26
 */
public class Demo53 {

    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
     * 且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字
     * 中有且只有一个数字不在该数组中，请找出这个数字。
     */
    public static int missingNumber(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                res = i;
            }
        }
        if (res == -1) {
            res = nums.length;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println(missingNumber2(a));
    }

    public static int missingNumber2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (mid == nums[mid]) {
                left++;
            }else{
                right--;
            }
        }
        return left;
    }

}
