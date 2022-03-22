package com.goat.calvin.service.provider.config.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *
 * <p> aop切面配置 <p/>
 *
 * @author xiefei15
 * @version 1.0.0
 * @since 2020/11/5 14:14
 */
@Aspect
@Component
public class MyAspect {
    @Pointcut("@annotation(com.goat.calvin.service.api.controller.*)")
    public void test(){}

    @Before("test()")
    public void before(){
        System.out.println("before test..");
    }

    @After("test()")
    public void after(){
        System.out.println("after test..");
    }

    @Around("test()")
    public Object around(ProceedingJoinPoint p){
        System.out.println("before1");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("after1");
        return o;
    }
}
