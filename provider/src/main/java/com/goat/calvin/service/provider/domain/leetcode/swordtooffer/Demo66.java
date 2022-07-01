package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/6/27 10:53
 */
public class Demo66 {

	/**
	 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
	 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
	 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
	 */
	public int[] constructArr(int[] a) {
		if (a == null) {
			return new int[0];
		}
		int[] res = new int[a.length];
		// 第一次遍历，从左到右乘积，到自己结束
		// 得到从当前位置之前的所有数的积
		// temp 表示从左往右的乘积
		int temp = 1;
		for (int i = 0; i < a.length; i++) {
			res[i] = temp;
			temp *= a[i];
		}
		// temp 表示从右往左的乘积
		temp = 1;
		// 第二次遍历，得到当前位置从右到左的乘积，
		// 并将其乘之前从左到右的积就是除去自己的积
		for (int i = a.length - 1; i >= 0; i--) {
			res[i] *= temp;
			temp *= a[i];
		}
		return res;
	}

}
