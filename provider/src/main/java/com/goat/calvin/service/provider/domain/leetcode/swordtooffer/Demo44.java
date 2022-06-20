package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/3/24 11:19
 */
public class Demo44 {

    /**
     * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，
     * 第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
     * 请写一个函数，求任意第n位对应的数字。
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            // 下次进位需要减的数值
            count = digit * start * 9;
        }
        // 找到第n位对应的数字
        long num = start + (n - 1) / digit;
        // 取余获得返回值
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
