package com.cks.netty.bye.pool;

import java.util.ServiceLoader;
import java.util.concurrent.*;
import java.util.concurrent.ThreadPoolExecutor.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: cks
 * @Date: Created by 10:08 2018/7/27
 * @Package: com.cks.netty.bye.pool
 * @Description:
 */
public class Demo {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 50,
                1000, TimeUnit.HOURS, new LinkedBlockingQueue<>(10),new DiscardOldestPolicy());
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i< 100;i++){
            poolExecutor.execute(() -> System.out.println(Thread.currentThread().getName()));
            count.getAndIncrement();
        }

        poolExecutor.shutdown();
//        while (Thread.activeCount() > 1){
//
//        }
        System.out.println(count.get());


    }
}
