package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/3/31 10:17
 */
public class Demo58 {

    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
     * 标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     */

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] ss = s.split(" ");
        for (int i = ss.length - 1; i >= 0; i--) {
            if (!"".equals(ss[i])) {
                sb.append(ss[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }


    public static String reverseLeftWords(String s, int n) {
        String pre = s.substring(0, n);
        String next = s.substring(n);
        return next + pre;
    }


    public static void main(String[] args) {
        System.out.println(reverseLeftWords("lrloseumgh",6));
    }
}
