package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiefei
 * @date 2022/7/12 9:28
 */
public class Demo1252 {

	public int oddCells(int m, int n, int[][] indices) {
		boolean[] r = new boolean[m], c = new boolean[n];
		int a = 0, b = 0;
		for (int[] info : indices) {
			a += (r[info[0]] = !r[info[0]]) ? 1 : -1;
			b += (c[info[1]] = !c[info[1]]) ? 1 : -1;
		}
		return a * (n - b) + (m - a) * b;
	}

	public static void main(String[] args) {
		int[][] nums = new int[2][2];
	}
}
