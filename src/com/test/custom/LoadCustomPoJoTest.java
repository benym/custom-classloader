package com.test.custom;


public class LoadCustomPoJoTest {

    public static void main(String[] args) throws Exception {
        // 初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父类加载器设置为应用程序类加载器AppClassLoader
        CustomClassLoader classLoader = new CustomClassLoader(
                "E:/ideaProject/custom-classloader/src");
        // 从磁盘中创建一个目录，将要加载的类的class放入目录
        Class<?> clazz = Class.forName("com.test.custom.pojo.TestUser", true, classLoader);
        Object obj = clazz.newInstance();
        System.out.println(obj.toString());
        System.out.println(clazz.getClassLoader());

        System.out.println();
        CustomClassLoader classLoader2 = new CustomClassLoader(
                "E:/ideaProject/custom-classloader/src");
        Class clazz1 = Class.forName("com.test.custom.pojo.repeat.TestUser", true, classLoader2);
        Object obj1 = clazz1.newInstance();
        System.out.println(obj1.toString());
        System.out.println(clazz1.getClassLoader());
    }
}
