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

    int num = 1000000007;
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }

        return product(n / 3, n % 3) % num;
    }

    public int product(int con, int remain) {
        int result = 0;
        if (remain == 0) {
            result = 3 ^ con;
        } else if (remain == 1) {
            result = (3 ^ (con - 1)) * 4;
        } else {
            result = (3 ^ con) * remain;
        }
        return result;
    }

    public int sum(int con){
        int result = 1;
        for (int i = 0; i < con ; i++) {
           result = result * 3;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(3 ^ 3);
    }
}
