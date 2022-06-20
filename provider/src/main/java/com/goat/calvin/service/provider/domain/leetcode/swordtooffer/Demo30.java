package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.Stack;

/**
 * @author xiefei
 * @date 2022/6/1 10:51
 */
public class Demo30 {

    static class MinStack {
        /**
         * initialize your data structure here.
         */
        // 全量数据
        Stack<Integer> a;
        // 最小数据
        Stack<Integer> b;

        public MinStack() {
            a = new Stack<>();
            b = new Stack<>();
        }

        public void push(int x) {
            a.push(x);
            // 记录每一次入队的最小值
            if(b.empty() || b.peek() >= x){
                b.add(x);
            }
        }

        // 删除尾部元素
        public void pop() {
            // 删除全量表中的最后一个元素，如果此元素也在最小值表，将其删除
            if(a.pop().equals(b.peek())){
                b.pop();
            }
        }
        // 获取第一个元素

        public int top() {
           return a.peek();
        }

        // 获取最小值
        public int min() {
            return b.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();
        minStack.pop();
        minStack.top();
        minStack.min();
    }
}
