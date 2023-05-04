package com.baizhi.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
    private static Properties env = new Properties();
    static {
        try {
            // 第一步 获得IO输入流
            InputStream inputStream = BeanFactory.class.getResourceAsStream("/applicationContext.properties");
            // 第二布 文件内容封装到 Properties集合中  key = userService value = com.baizhi.UserServiceImpl
            env.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
        对象的创建方式
            1.直接调用构造方法 创建对象 UserService userService = new UserServiceImpl();
            2. 通过反射的形式创建对象 解耦合
                Class<?> clazz = Class.forName("com.baizhi.basic.UserServiceImpl");
                userService = (UserService) clazz.newInstance();

     */

    public static UserService getUserService() {
        UserService userService = null;
        try {
            Class<?> clazz = Class.forName(env.getProperty("userService"));
            userService = (UserService) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return userService;

    }

    public static UserDao getUserDao() {
        UserDao userDao = null;
        try {
            Class<?> clazz = Class.forName(env.getProperty("userDao"));
            userDao = (UserDao) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return userDao;
    }

    /*
    key 小配置文件中的key [userDao,userService]
     */
    public static Object getBean(String key){
        Object ret = null;
        try {
            Class clazz = Class.forName(env.getProperty(key));
            ret = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
