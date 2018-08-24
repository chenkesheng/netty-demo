package com.cks.netty.bye.thread;

/**
 * @Author: cks
 * @Date: Created by 9:23 2018/7/26
 * @Package: com.cks.netty.bye.thread
 * @Description:
 */
public class Product {

    private Integer id;

    private String name;

    public Product(Integer id, String name) {
        System.out.println("蛋糕开始生产......");
        this.id = id;
        this.name = name;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("蛋糕生产完毕......");
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
