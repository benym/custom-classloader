package com.test.custom;

import java.io.FileInputStream;
import java.util.concurrent.atomic.AtomicInteger;


public class CustomClassLoaderCopy extends ClassLoader {

    private String classPath;

    public CustomClassLoaderCopy() {
    }

    public CustomClassLoaderCopy(String classPath) {
        this.classPath = classPath;
    }

    private AtomicInteger count = new AtomicInteger(0);

    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        String a = classPath + "/" + name + ".class";
        FileInputStream fileInputStream;
        if (count.get() == 0) {
            fileInputStream = new FileInputStream(
                    classPath + "/" + name + ".class");
            count.incrementAndGet();
        } else {
            fileInputStream = new FileInputStream(
                    "/Users/ben/Desktop/project/test/src" + "/" + name + ".class");
        }

        int len = fileInputStream.available();
        byte[] data = new byte[len];
        fileInputStream.read(data);
        fileInputStream.close();
        return data;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组。
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
