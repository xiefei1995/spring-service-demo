package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/6/21 11:26
 */
public class Demo53_2 {

    /**
     * 统计一个数字在排序数组中出现的次数。
     * <p>
     * 思路：统计第一次出现target的位置和第一个比target出现的位置
     * 他们的index差就是出现的次数
     */
    public int search(int[] nums, int target) {
        // 找比target大的最近的 - 第一个target出现的位置
        return getFirstIndex(nums, target) - getFirstIndex(nums, target - 1);
    }

    public int getFirstIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 找出来的是target右边的一个值
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
