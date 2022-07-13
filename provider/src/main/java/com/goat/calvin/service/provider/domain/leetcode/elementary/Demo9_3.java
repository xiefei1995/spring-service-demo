package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/13 14:38
 */
public class Demo9_3 {

	/**
	 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，
	 * 输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
	 * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
	 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。
	 * 因此，在 示例 2 中，输入表示有符号整数 -3，
	 * 输出表示有符号整数 -1073741825
	 */

	public int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			// res左移动一位，移动后的位置值为0
			res = res << 1;
			// res下一位为n的最后一位,这里算是加上
			res = res | (n & 1);
			n = n >> 1;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(1 | 1);
	}

}
