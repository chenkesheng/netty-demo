package com.cks.netty.bye;

/**
 * @Author: cks
 * @Date: Created by 2019/7/5 9:06
 * @Package: com.cks.netty.bye
 * @Description:
 */
public class Singleton {

    /**
     * 恶汉式单例
     */
//    private static Singleton instance = new Singleton();
//
//    private Singleton(){}
//
//    public static Singleton getInstance(){
//        return instance;
//    }

    /**
     * 懒汉式单例
     */
//    private static Singleton instance;
//
//    private Singleton(){}
//
//    public static Singleton getInstance(){
//        if (instance == null){
//            instance = new Singleton();
//        }
//        return instance;
//    }

    /**
     * 线程安全的懒汉
     */
//    private volatile static Singleton instance;
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    /**
     * 静态内部类
     *
     */
//    private static class SingletonClassInstance {
//
//        private static Singleton instance = new Singleton();
//
//    }
//
//    private Singleton() {
//    }
//
//    public static Singleton getInstance() {
//        return SingletonClassInstance.instance;
//    }

    /**
     * 静态代码块
     */
    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

}
