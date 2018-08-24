package com.cks.netty.bye.thread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: cks
 * @Date: Created by 17:13 2018/7/25
 * @Package: com.cks.netty.bye.thread
 * @Description: CyclicBarrier
 */
public class CyclicBarrierDemo {

    Random random = new Random();
    public void meeting(CyclicBarrier barrier) {
        try {
            Thread.sleep(random.nextInt(4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "到达会议室,等待中。。。");

        if (Thread.currentThread().getName().equals("Thread-6")){
            throw new RuntimeException();
        }
        try {
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"发言");
    }

    public static void main(String[] args) {
        CyclicBarrierDemo demo = new CyclicBarrierDemo();
        CyclicBarrier barrier = new CyclicBarrier(10, () -> System.out.println("好！我们开始开会。。。。"));
        for(int i = 0;i<10;i++){
            new Thread(() -> {
                demo.meeting(barrier);
            }).start();
        }
    }
}
