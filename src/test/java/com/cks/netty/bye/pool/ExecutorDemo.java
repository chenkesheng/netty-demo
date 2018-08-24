package com.cks.netty.bye.pool;

import java.util.HashSet;
import java.util.concurrent.*;

/**
 * @Author: cks
 * @Date: Created by 13:02 2018/7/27
 * @Package: com.cks.netty.bye.pool
 * @Description:
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        //固定大小的线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        //不够就创建  线程空闲60秒 就销毁的线程池
//        ExecutorService pool = Executors.newCachedThreadPool();
//        ExecutorService singlePool = Executors.newSingleThreadExecutor();
//        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10);
//        ExecutorService pool = Executors.newWorkStealingPool();

        while (true) {
            Future<Integer> future = pool.submit(() -> 100);
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
//            pool.schedule(() -> System.out.println(Thread.currentThread().getName()), 5, TimeUnit.SECONDS);
//            pool.execute(()-> {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
