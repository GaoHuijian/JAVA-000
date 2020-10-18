package com.gaohj;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 自定义classloader
 * @author gaohj
 */
public class HelloClassLoader extends  ClassLoader{

    public static void main(String[] args) {
        try {
            Class<?> clazz = new HelloClassLoader().findClass("Hello");
            Object object = clazz.newInstance();
            Method method = clazz.getMethod("hello");
            method.invoke(object);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
        	//读取二进制文件
        	String path = this.getClass().getResource("/Hello.xlass").getPath();
        	File file = new File(path);
        	Path filePath = Paths.get(file.getPath());
            byte[] bytes = Files.readAllBytes(filePath);
            for (int i = 0; i < bytes.length; ++i) {
            	bytes[i] = (byte)(255 - bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            return super.findClass(name);
        }
    }
}
