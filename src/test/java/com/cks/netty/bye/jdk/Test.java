package com.cks.netty.bye.jdk;

import com.cks.netty.bye.collection.LRUMap;
import com.google.common.collect.BiMap;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Map;
import java.util.Set;

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

        Map<String, String> map = new BiMap<String, String>() {
            @Nullable
            @Override
            public String put(@Nullable String s, @Nullable String s2) {
                return null;
            }

            @Nullable
            @Override
            public String forcePut(@Nullable String s, @Nullable String s2) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends String> map) {

            }

            @Override
            public Set<String> values() {
                return null;
            }

            @Override
            public BiMap<String, String> inverse() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public String get(Object key) {
                return null;
            }

            @Override
            public String remove(Object key) {
                return null;
            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Set<Entry<String, String>> entrySet() {
                return null;
            }
        };

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

//        LocalDate date = LocalDate.now();
//
//        System.out.println(String.valueOf(date));

//        System.out.println(LocalDate.of(2018, 02, 20));
//        System.out.println(LocalDate.parse("2018-02-20"));
//
//        LocalDate date1 = LocalDate.parse("2018-02-20");
//
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        System.out.println(tomorrow + "============");
//
        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);
//
//        System.out.println(previousMonthSameDay);
//
//        DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
//        int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();
//
//        System.out.println(sunday);
//
//        System.out.println(twelve);
//
//        boolean leapYear = LocalDate.now().isLeapYear();
//
//        System.out.println(leapYear);
//
//        boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
//        boolean isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));
//
//        System.out.println(notBefore);
//        System.out.println(isAfter);

//        LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
//        LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12")
//                .with(TemporalAdjusters.firstDayOfMonth());
//
//        System.out.println(beginningOfDay);
//        System.out.println(firstDayOfMonth);

//        LocalTime now = LocalTime.now();



        LocalTime sixThirty = LocalTime.of(15, 30);
        System.out.println(sixThirty);

        System.out.println(LocalDateTime.now());

        System.out.println(LocalDateTime.now());
    }
}
