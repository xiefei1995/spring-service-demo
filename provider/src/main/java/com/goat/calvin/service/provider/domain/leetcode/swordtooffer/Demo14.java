package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xiefei
 * @date 2022/4/1 10:24
 */
public class Demo14 {
    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * 贪心算法：先找到最有利的值，然后再找最后一个值的分配方式从而得到最合适的值
     */

    int NUM_MOD = 1000000007;

    public int cuttingRope(int n) {
        // 绳子每一段为3时得到的数据最好
        if (n <= 3) return n - 1;
        // 底数
        long base = 3;
        // 指数
        int pow = n / 3;
        // 余数
        int last = n % 3;
        long res = 1;
        // 余数为2 直接 * 2
        if (last == 2) {
            return (int) (myPow(res, base, pow) * 2 % NUM_MOD);
        }
        // 余数为1 不如指数少一再* 4
        if (last == 1) {
            return (int) (myPow(res, base, pow - 1) * 4 % NUM_MOD);
        }
        return (int) (myPow(res, base, pow) % NUM_MOD);
    }

    // 求指定底数和指定幂数的积
    public long myPow(long res, long base, long pow) {
        while (pow > 0) {
            // 指数幂为单数再乘一个底数，保证后面位运算的值
            if ((pow & 1) == 1) {
                res = res * base % NUM_MOD;
            }
            // 指数幂右移一位（除以二），例子 8^2 = 64^1
            pow = pow >> 1;
            base = base * base % NUM_MOD;
        }
        return res;
    }

}
