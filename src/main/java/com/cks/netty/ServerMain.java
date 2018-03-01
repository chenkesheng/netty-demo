package com.cks.netty;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: cks
 * @Date: Created by 下午14:35 2018/2/27
 * @Package: com.cks.netty
 * @Description: 启动类
 */
public class ServerMain {
    public static volatile boolean running = true;

    public static void main(String[] args) {
        final ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        try {
            context.start();

            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    try {
                        context.stop();
                        running = false;
                        ServerMain.class.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            });

            synchronized (ServerMain.class) {
                while (running) {
                    ServerMain.class.wait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}
