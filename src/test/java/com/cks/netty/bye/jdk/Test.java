package com.cks.netty.bye.jdk;

import com.cks.netty.bye.collection.LRUMap;

import java.util.Map;

/**
 * @Author: cks
 * @Date: Created by 14:06 2018/8/24
 * @Package: com.cks.netty.bye.jdk
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
//        //测试jdk动态代理
//        ICks cks = new CksImpl();
//        Caculator caculator = new CaculaterImpl();
//        IProxyProvider proxyProvider = new JDKProxyImpl(cks,caculator);
//        Caculator caculator1 = (Caculator) proxyProvider.getProxyObj();
//        System.out.println(caculator1.subtract(3, 1));

        LRUMap<String, Integer> lruMap = new LRUMap<>(5);

        lruMap.put("第一个", 1);
        lruMap.put("第二个", 2);
        lruMap.put("第三个", 3);
        lruMap.put("第四个", 4);
        lruMap.put("第五个", 5);


        lruMap.get("第一个");
        lruMap.get("第三个");

        lruMap.put("第六个", 6);
        lruMap.put("第七个", 7);
        lruMap.put("第八个", 8);



        System.out.println(lruMap.size());
        for (Map.Entry data : lruMap.entrySet()) {
            System.out.println("key：" + data.getKey() + ",value:" + data.getValue());
        }
    }
}
