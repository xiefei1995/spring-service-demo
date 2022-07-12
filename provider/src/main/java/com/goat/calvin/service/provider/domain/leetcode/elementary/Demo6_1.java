package com.goat.calvin.service.provider.domain.leetcode.elementary;

import com.alibaba.fastjson.util.AntiCollisionHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiefei
 * @date 2022/7/7 14:22
 */
public class Demo6_1 {

	/**
	 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	 */
	Map<Integer, Integer> map = new HashMap<>(16);

	public int climbStairs(int n) {
		if (n == 1) {
			map.put(1, 1);
			return 1;
		}
		if (n == 2) {
			map.put(2, 2);
			return 2;
		}
		if (map.get(n - 1) != null && map.get(n - 2) != null) {
			int res = map.get(n - 1) + map.get(n - 2);
			map.put(n, res);
			return res;
		} else {
			return climbStairs(n - 1) + climbStairs(n - 2);
		}
	}
}
