package com.cks.netty.bye.thread;

import java.util.Random;

/**
 * @Author: cks
 * @Date: Created by 9:31 2018/7/26
 * @Package: com.cks.netty.bye.thread
 * @Description:
 */
public class ProductFactory {

    public Future createProduct(String name) {
        //创建订单
        Future future = new Future();
        System.out.println("下单成功......可以去上班了");

        //生产产品
        new Thread(()-> {
            Product product = new Product(new Random().nextInt(), name);
            future.setProduct(product);
        }).start();


        return future;
    }
}
