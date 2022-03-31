package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/3/30 9:04
 */
public class Demo15 {

    /**
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），
     * 返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
     */
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            // 如果&1等于1，说明该位置为1，为0则为0
            res += n & 1;
            // 数据左一位
            n = n >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(2));
    }

}
