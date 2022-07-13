package com.goat.calvin.service.provider.domain.leetcode.elementary;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/7/12 11:08
 */
public class Demo7_2 {

	static class MinStack {

		List<Integer> data;
		List<Integer> min;

		public MinStack() {
			data = new ArrayList<>();
			min = new ArrayList<>();
		}

		public void push(int val) {
			data.add(val);
			if (min.size() == 0) {
				min.add(val);
			} else {
				if (val <= min.get(0)) min.add(0, val);
			}
		}

		public void pop() {
			Integer remove = data.remove(data.size() - 1);
			if (min.contains(remove)) min.remove(remove);
		}

		public int top() {
			return data.get(data.size() - 1);
		}

		public int getMin() {
			// 如果min中没有数据那说明就应该取data中的了
			if (min.size() == 0) return data.get(0);
			return min.get(0);
		}

	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(512);
		minStack.push(-1024);
		minStack.push(-1024);
		minStack.push(512);
		minStack.pop();
		minStack.getMin();
		minStack.pop();
		minStack.getMin();
		minStack.pop();
		minStack.getMin();
	}

}
