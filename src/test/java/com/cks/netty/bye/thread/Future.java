package com.cks.netty.bye.thread;

/**
 * @Author: cks
 * @Date: Created by 9:35 2018/7/26
 * @Package: com.cks.netty.bye.thread
 * @Description:
 */
public class Future {

    private Product product;

    private boolean flag;

    public synchronized void setProduct(Product product) {
        if (flag) {
            return;
        }
        this.product = product;
        flag = true;
        notifyAll();
    }

    public synchronized Product getProduct() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (product == null) {
        }
        return product;
    }
}
