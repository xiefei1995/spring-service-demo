package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.Stack;

/**
 * @author xiefei
 * @date 2022/4/14 9:56
 */
public class Demo31 {
    /**
     * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1}
     * 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
     */

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 判断出栈和入栈是否一致
        // 这里的出栈和入栈是同时进行的
        // 定义一个栈来模拟放入的过程：先进后出
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            // 放入栈时比较是否符合出栈的顺序，直到stack为空
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
