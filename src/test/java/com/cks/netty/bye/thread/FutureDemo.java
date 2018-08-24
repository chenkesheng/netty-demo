package com.cks.netty.bye.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: cks
 * @Date: Created by 9:02 2018/7/26
 * @Package: com.cks.netty.bye.thread
 * @Description:
 */
public class FutureDemo {

    public static void main(String[] args) {
        Callable<Integer> callable = () -> {
            Thread.sleep(3000);
            return 1;
        };
//
        FutureTask<Integer> futureTask = new FutureTask(callable);
//        Thread thread = new Thread(futureTask);
//        thread.start();
//
//        //做别的事情
//        System.out.println("干点别的事情啊......");
//
//        try {
//            Integer result = futureTask.get();
//            System.out.println("拿到的结果为: " + result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        ProductFactory pf = new ProductFactory();
        //下单交钱
        Future future = pf.createProduct("蛋糕");


        System.out.println("我去上班了,下了班我来取蛋糕....");
        //拿着订单获取产品获取产品
        System.out.println("下班了我来取蛋糕....: " + future.getProduct());
    }
}
