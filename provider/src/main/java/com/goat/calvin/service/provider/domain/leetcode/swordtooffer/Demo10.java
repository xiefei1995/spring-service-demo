package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiefei
 * @date 2022/3/30 9:23
 */
public class Demo10 {
    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）
     * 数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * <p>
     * 思路：递归 + 数值记录
     */

    static Map<Integer, Integer> fibMap = new HashMap<>(32);

    public static int fib(int n) {
        if (n == 0) {
            fibMap.put(0, 0);
            return 0;
        }
        if (n == 1) {
            fibMap.put(1, 1);
            return 1;
        }
        int val;
        if (fibMap.containsKey(n - 1) && fibMap.containsKey(n - 2)) {
            val = (fibMap.get(n - 1) + fibMap.get(n - 2)) % 1000000007;
        } else {
            val = (fib(n - 1) + fib(n - 2)) % 1000000007;
        }
        fibMap.put(n, val);
        return val;
    }

    public static void main(String[] args) {
        System.out.println(fib(46));
    }
}
