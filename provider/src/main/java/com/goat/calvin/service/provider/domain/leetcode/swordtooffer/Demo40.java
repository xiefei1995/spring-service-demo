package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.Arrays;

/**
 * @author xiefei
 * @date 2022/3/30 10:17
 */
public class Demo40 {

    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。
     * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     */

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

}
