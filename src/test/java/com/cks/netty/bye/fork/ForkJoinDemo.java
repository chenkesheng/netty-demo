package com.cks.netty.bye.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: cks
 * @Date: Created by 14:52 2018/7/26
 * @Package: com.cks.netty.bye.fork
 * @Description:
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {

    private int begin;
    private int end;

    public ForkJoinDemo(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    //把一大份分成多份小份的
    @Override
    protected Integer compute() {
        System.out.println(Thread.currentThread().getName() + " 线程进来了");
        int sum = 0;
        //拆分任务
        if ((end - begin) <= 2) {
            for (int i = begin; i <= end; i++) {
                sum += i;
            }
        } else {

            ForkJoinDemo f1 = new ForkJoinDemo(begin, (begin + end) / 2);
            ForkJoinDemo f2 = new ForkJoinDemo((begin + end) / 2 + 1, end);

            //执行子任务
            f1.fork();
            f2.fork();

            Integer a = f1.join();
            Integer b = f2.join();
            sum = a + b;
        }


        return sum;
    }

    public static void main(String[] args) throws Exception {

        ForkJoinPool pool = new ForkJoinPool();
        Future<Integer> future = pool.submit(new ForkJoinDemo(1, 10000));

        System.out.println("...........");
        System.out.println("计算的值为:" + future.get());
    }
}
