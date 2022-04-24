package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

import java.util.concurrent.Callable;

/**
 * @author xiefei
 * @date 2022/4/11 9:37
 */
public class DemoTask {
    /**
     * 实现一个单任务管理器，要求1.任务可执行，2.可以随时暂停任务，3.可获取任务状态
     */
    Integer status = 0;
    Task task;

    class Task implements Callable {
        @Override
        public Object call() throws Exception {
            status = 2;
            return null;
        }
    }

    void start() throws Exception {
        task = new Task();
        status = 1;
        task.call();
    }

    void stop() throws InterruptedException {
        if (status == 3) {
            task.notify();
            return;
        }
        status = 3;
        task.wait();
    }

    int status() {
        return status;
    }
}
