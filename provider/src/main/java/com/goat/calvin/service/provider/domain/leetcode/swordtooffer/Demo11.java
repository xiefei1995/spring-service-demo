package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/4/2 10:33
 */
public class Demo11 {

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，
     * 并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，
     * 数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
     */

    public static int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (right - left)/2 + left;
            // 直接和最后边的比较，因为题干告诉之前的数组是有序的
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if(numbers[mid] > numbers[right]){
                left = mid + 1;
            }else{
                right -= 1;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,3,3,3,3,3,1,3};
        System.out.println(minArray(nums));
    }
}
