package com.goat.calvin.service.domain.impl;

import com.goat.calvin.service.domain.SeataDemo;
import io.seata.spring.annotation.GlobalTransactional;

/**
 * @author xiefei15
 * @version 1.0.0
 * @since 2021/3/3 14:54
 */
public class SeataDemoImpl implements SeataDemo {


    /**
     *  分布式调用
     */
    @GlobalTransactional(rollbackFor = Exception.class)
    @Override
    public void helloWorld() {
        // feign1

        // feign2
    }
}
