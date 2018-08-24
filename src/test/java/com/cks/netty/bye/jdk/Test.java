package com.cks.netty.bye.jdk;

/**
 * @Author: cks
 * @Date: Created by 14:06 2018/8/24
 * @Package: com.cks.netty.bye.jdk
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
        //测试jdk动态代理
        ICks cks = new CksImpl();
        Caculator caculator = new CaculaterImpl();
        IProxyProvider proxyProvider = new JDKProxyImpl(cks,caculator);
        Caculator caculator1 = (Caculator) proxyProvider.getProxyObj();
        System.out.println(caculator1.substrct(3, 1));
    }
}
