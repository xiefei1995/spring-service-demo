package com.goat.calvin.service.provider.domain.controller.classloader;

/**
 * @author xiefei
 * @date 2022/4/25 13:36
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 自定义加载class地址
        return super.findClass(name);
    }

}
