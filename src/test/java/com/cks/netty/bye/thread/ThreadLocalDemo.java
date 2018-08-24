package com.cks.netty.bye.thread;

/**
 * @Author: cks
 * @Date: Created by 14:36 2018/7/25
 * @Package: com.cks.netty.bye.thread
 * @Description:
 */
public class ThreadLocalDemo {

    private ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);

    public int getNext(){
        Integer value = count.get();
        value ++;
        count.set(value);
        return value;
    }

    public static void main(String[] args) {
        ThreadLocalDemo demo = new ThreadLocalDemo();
        new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName() + ":" + demo.getNext());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName() + ":" + demo.getNext());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().getName() + ":" + demo.getNext());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
