package com.goat.calvin.service.provider.domain.leetcode.daylywork.aug;

/**
 * @author：xiefeiyf
 * @date：2022/8/19 : 9:23
 */
public class Demo19 {

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            int start = startTime[i];
            int end = startTime[i];
            if (start <= queryTime && queryTime <= end) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] start = {1,2,3};
        int[] end = {3,2,7};
        int query = 4;
        System.out.println(busyStudent(start, end, query));
    }

}
