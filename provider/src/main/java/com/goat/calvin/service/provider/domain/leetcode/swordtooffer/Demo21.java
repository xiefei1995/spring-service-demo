package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/4/24 9:53
 */
public class Demo21 {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
     */
    public static int[] exchange(int[] nums) {
        int index = nums.length;
        int[] res = new int[index];
        int pre = 0;
        for (int num : nums) {
            if ((num & 1) == 1) {
                res[pre] = num;
                pre++;
            } else {
                res[index - 1] = num;
                index--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(exchange(nums));
    }
}
