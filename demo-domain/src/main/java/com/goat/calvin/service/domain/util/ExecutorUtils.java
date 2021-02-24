package com.goat.calvin.service.domain.util;

import java.util.concurrent.*;

/**
 * @author xiefei15
 * @version 1.0.0
 * @since 2021/1/28 18:00
 */
public class ExecutorUtils {

    /**
     * 核心线程数
     */
    private static final int CORE_POOL_SIZE = 5;

    /**
     * 最大线程数
     */
    private static final int MAX_POOL_SIZE = 20;

    /**
     * 存活时间
     */
    private static final long KEEP_ALIVE_TIME = 20L;

    /**
     * 时间单位
     */
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    /**
     *  阻塞队列
     */
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingDeque<>();

    /**
     * 固定核心大小线程池
     */
    public static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
            CORE_POOL_SIZE,MAX_POOL_SIZE,KEEP_ALIVE_TIME,TIME_UNIT,WORK_QUEUE,Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());


}
