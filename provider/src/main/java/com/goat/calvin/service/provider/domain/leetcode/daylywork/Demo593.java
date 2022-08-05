package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiefei
 * @date 2022/7/29 10:34
 */
public class Demo593 {

	/**
	 * 给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
	 * <p>
	 * 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
	 * <p>
	 * 一个 有效的正方形 有四条等边和四个等角(90度角)。
	 */

	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		// 采用边长计算
		double p12 = Math.pow((p1[0] - p2[0]), 2) + Math.pow((p1[1] - p2[1]), 2);
		double p23 = Math.pow((p2[0] - p3[0]), 2) + Math.pow((p2[1] - p3[1]), 2);
		double p34 = Math.pow((p3[0] - p4[0]), 2) + Math.pow((p3[1] - p4[1]), 2);
		double p41 = Math.pow((p4[0] - p1[0]), 2) + Math.pow((p4[1] - p1[1]), 2);
		double p13 = Math.pow((p1[0] - p3[0]), 2) + Math.pow((p1[1] - p3[1]), 2);
		double p24 = Math.pow((p2[0] - p4[0]), 2) + Math.pow((p2[1] - p4[1]), 2);
		List<Double> list = new ArrayList<>(6);
		list.add(p12);
		list.add(p23);
		list.add(p34);
		list.add(p41);
		list.add(p13);
		list.add(p24);
		if (list.contains(0.0d)) return false;
		Collections.sort(list);
		boolean flag = list.get(0).equals(list.get(1));
		for (int i = 1; i < 3; i++) {
			flag = flag && (list.get(i).equals(list.get(i + 1)));
			if (!flag) return false;
		}
		return list.get(4).equals(list.get(5));
	}

	public static void main(String[] args) {
		int[] p1 = {0, 0};
		int[] p2 = {0, 0};
		int[] p3 = {0, 0};
		int[] p4 = {0, 0};
		System.out.println(validSquare(p1, p2, p3, p4));
	}

}
