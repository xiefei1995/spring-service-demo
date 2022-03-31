package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.Stack;

/**
 * @author xiefei
 * @date 2022/3/30 10:03
 */
public class Demo09 {
    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
     * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     */
    Stack<Integer> insertStack;
    Stack<Integer> deleteStack;

    public Demo09() {
        insertStack = new Stack<>();
        deleteStack = new Stack<>();
    }

    public void appendTail(int value) {
        insertStack.add(value);
        deleteStack.add(value);
    }

    public int deleteHead() {
        if (deleteStack.isEmpty()) return -1;
        return deleteStack.remove(0);
    }
}
