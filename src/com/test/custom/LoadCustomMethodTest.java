package com.test.custom;

import java.lang.reflect.Method;


public class LoadCustomMethodTest {

    public static void main(String[] args) throws Exception {
        // 初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父类加载器设置为应用程序类加载器AppClassLoader
        CustomClassLoader classLoader = new CustomClassLoader(
                "E:/ideaProject/custom-classloader/src");
        // 从磁盘中创建一个目录，将要加载的类的class放入目录
        Class clazz = classLoader.loadClass("com.test.custom.service.TestService");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("testPrint", String.class);
        method.invoke(obj, "李四");
        System.out.println(clazz.getClassLoader());
    }
}
