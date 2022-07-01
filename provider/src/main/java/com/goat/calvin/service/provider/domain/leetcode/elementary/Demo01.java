package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/6/28 9:19
 */
public class Demo01 {

	/**
	 * 升序的数组
	 */
	public static int removeDuplicates(int[] nums) {
		int moveCount = 0;
		// 元素最多到nums.length - 1
		for (int i = 0; i < nums.length - 1 - moveCount; i++) {
			if (nums[i] == nums[i + 1]) {
				move(nums, i);
				moveCount++;
				i--;
			}
		}
		return nums.length - moveCount;
	}

	public static void move(int[] nums, int index) {
		for (int i = index; i < nums.length - 1; i++) {
			nums[i] = nums[i + 1];
		}
	}


	public static int removeDuplicates2(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		int left = 0;
		for (int right = 1; right < nums.length; right++) {
			// 比较左指针的下一个index是否和右指针相同
			// 直到不相同，左指针右移动，否则右指针一直移动
			if (nums[left] != nums[right]) {
				nums[++left] = nums[right];
			}
		}
		return ++left;
	}

	public static void main(String[] args) {
		int[] nums = {0, 0, 1};
		removeDuplicates2(nums);
	}
}
