package com.cks.netty.bye.jdk;

/**
 * @Author: cks
 * @Date: Created by 14:05 2018/8/24
 * @Package: com.cks.netty.bye.jdk
 * @Description:
 */
public class CaculaterImpl implements Caculator {
    @Override
    public int subtract(int a, int b) {
        System.out.println("方法执行中");
        return a - b;
    }
}
