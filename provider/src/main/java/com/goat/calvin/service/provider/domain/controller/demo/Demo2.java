package com.goat.calvin.service.provider.domain.controller.demo;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author xiefei
 * @date 2022/4/26 10:16
 */
public class Demo2 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(16);
        for (int i = 0; i < 20; i++) {
            boolean insert = queue.offer(i);
            System.out.println(insert);
        }
    }
}
