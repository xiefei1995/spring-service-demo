package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

import com.sun.org.apache.bcel.internal.generic.LADD;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author xiefei
 * @date 2022/8/2 9:16
 */
public class MyCircularQueue {

	/**
	 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）
	 * 原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
	 * <p>
	 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了
	 * ，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
	 * <p>
	 * 你的实现应该支持如下操作：
	 * <p>
	 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
	 * Front: 从队首获取元素。如果队列为空，返回 -1 。
	 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
	 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
	 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
	 * isEmpty(): 检查循环队列是否为空。
	 * isFull(): 检查循环队列是否已满。
	 */

	Queue<Integer> queue;
	int maxSize;
	int lastVal;
	public MyCircularQueue(int k) {
		queue = new ArrayBlockingQueue<>(k);
		maxSize = k;
	}

	public boolean enQueue(int value) {
		if(queue.size() == maxSize) return false;
		lastVal = value;
		return queue.offer(value);
	}

	public boolean deQueue() {
		if (queue.isEmpty()) return false;
		queue.poll();
		return true;
	}

	public int Front() {
		if(queue.isEmpty()) return -1;
		return queue.peek();
	}

	public int Rear() {
		if(queue.isEmpty()) return -1;
		return lastVal;
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public boolean isFull() {
		return queue.size() == maxSize;
	}

	public static void main(String[] args) {
		MyCircularQueue queue = new MyCircularQueue(6);
		queue.enQueue(6);
		queue.Rear();
		queue.Rear();
		queue.deQueue();
		queue.enQueue(5);
		queue.Rear();
		queue.deQueue();
		queue.Front();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
	}
}
