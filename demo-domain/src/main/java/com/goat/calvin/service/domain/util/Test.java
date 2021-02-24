package com.goat.calvin.service.domain.util;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池的多task执行demo
 * @author xiefei15
 * @version 1.0.0
 * @since 2021/2/4 14:39
 */
public class Test {

    public static void main(String[] args) {

        final CountDownLatch countDownLatch = new CountDownLatch(10);

        ThreadPoolExecutor executor = ExecutorUtils.EXECUTOR;
        for(int i = 0;i<10;i++){
            executor.submit(new Task(i));
            countDownLatch.countDown();
        }
    }

    static class Task implements Callable<Integer> {

        private int i;

        private Task(int i){
            this.i = i;
        }

        @Override
        public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "---" + i);
                return i;
        }
    }


    static class Task2 implements Callable<String> {

        private String i;

        private Task2(String i){
            this.i = i;
        }

        @Override
        public String call() throws Exception {
            System.out.println("task2执行完毕");
            return i;
        }
    }

}
