package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/6/22 9:46
 */
public class Demo59 {

	/**
	 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back
	 * 和 pop_front 的均摊时间复杂度都是O(1)。
	 * 若队列为空，pop_front 和 max_value 需要返回 -1
	 */

	LinkedList<Integer> list;
	List<Integer> maxList;


	public Demo59() {
		list = new LinkedList<>();
		maxList = new ArrayList<>();
	}

	public int max_value() {
		if (list.isEmpty()) return -1;
		return maxList.get(maxList.size() - 1);
	}

	public void push_back(int value) {
		list.addLast(value);
		if (maxList.isEmpty()) {
			maxList.add(value);
		} else {
			for (int i = 0; i < maxList.size(); i++) {
				if (maxList.get(i) == value) {
					return;
				}
				if (maxList.get(i) > value) {
					maxList.add(i, value);
					return;
				}
				if (i == maxList.size() - 1) {
					maxList.add(value);
				}
			}
		}
	}

	public int pop_front() {
		if (list.isEmpty()) return -1;
		Integer pop = list.pop();
		maxList.remove(pop);
		return pop;
	}

	public static void main(String[] args) {
		Demo59 demo59 = new Demo59();
		demo59.push_back(1);
		demo59.push_back(2);
		demo59.max_value();
		demo59.pop_front();
		demo59.max_value();
	}

}
