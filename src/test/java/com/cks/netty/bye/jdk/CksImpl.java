package com.cks.netty.bye.jdk;

/**
 * @Author: cks
 * @Date: Created by 13:58 2018/8/24
 * @Package: com.cks.netty.bye.jdk
 * @Description:
 */
public class CksImpl implements ICks {
    @Override
    public void before() {
        System.out.println("开始");
    }

    @Override
    public void after() {
        System.out.println("结束");
    }
}
