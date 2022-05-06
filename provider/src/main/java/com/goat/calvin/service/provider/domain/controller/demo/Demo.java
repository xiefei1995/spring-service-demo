package com.goat.calvin.service.provider.domain.controller.demo;

import java.io.File;

/**
 * @author xiefei15
 * @version 1.0.0
 * @since 2020/11/2 9:47
 */
public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.test("我敲，京");
    }

    public static void test() {
        Demo demo = new Demo();
        demo.test("我敲，京");
    }

    public void test(String s){
        System.out.println("非静态方法：" + s);
    }
}
