package com.cks.netty.bye.thread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: cks
 * @Date: Created by 15:40 2018/7/25
 * @Package: com.cks.netty.bye.thread
 * @Description:
 */
public class CountDownLatchDemo {
    private int[] nums;

    public CountDownLatchDemo(int line) {
        nums = new int[line];
    }

    public void ca(String line, int index, CountDownLatch latch) {
        String[] ns = line.split(",");
        int total = 0;
        for (String n : ns) {
            total += Integer.valueOf(n);
        }
        nums[index] = total;
        System.out.println(Thread.currentThread().getName() + "执行计算任务" + line + "结果为:" + total);
        latch.countDown();
    }

    public void sum() {
        System.out.println("线程汇总开始.......");
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        System.out.println("最终结果为:" + total);
    }

    public static void main(String[] args) {
        List<String> contents = readFile();
        CountDownLatchDemo demo = new CountDownLatchDemo(contents.size());

        CountDownLatch latch = new CountDownLatch(contents.size());

        for (int i = 0; i < contents.size(); i++) {
            final int j = i;
            new Thread(() -> {
                demo.ca(contents.get(j), j, latch);
            }).start();
        }

//        while (Thread.activeCount() > 1) {
//
//        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo.sum();
    }

    public static List<String> readFile() {
        List<String> contents = new ArrayList<>();

        String line;
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader("e:\\nums.txt"));
            while ((line = bf.readLine()) != null) {
                contents.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return contents;
    }
}
