package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

/**
 * @author：xiefeiyf
 * @date：2022/8/9 : 9:28
 */
public class Day9 {

    public static int minStartValue(int[] nums) {
        int res = 1;
        int pre = 1;
        for (int num : nums) {
            while (pre + num < 1) {
                res++;
                pre++;
            }
            pre += num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,11111};
        System.out.println(minStartValue(nums));
    }

}
