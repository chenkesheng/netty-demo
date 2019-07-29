package com.cks.netty.bye;

import java.util.List;

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
     * 静态内部类的优点是：外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存。即当SingleTon第一次被加载时，
     * 并不需要去加载SingletonClassInstance，只有当getInstance()方法第一次被调用时，
     * 才会去初始化INSTANCE,第一次调用getInstance()方法会导致虚拟机加载SingletonClassInstance类，
     * 这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
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
