package com.cks.netty.bye;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

/**
 * @Author: cks
 * @Date: Created by 14:46 2018/2/24
 * @Package: com.cks.netty.bye
 * @Description:
 */
public class ByeTest {

    @Test
    public void testSize(){
        String s = "this is test Response \r\n";
        System.out.println(s.getBytes(Charset.defaultCharset()).length);
    }

    @Test
    public void test01() {
        int shift = 2048 ^ 1 << 11;
        System.out.println(shift);
    }

    @Test
    public void test02() {
        long i = 1;
        for (int j = 0; j < 11; j++) {
            i = i * 2;
        }
        System.out.println(i);
    }

    @Test
    public void test03() {
        int i = (1 << 24 - 11);
        System.out.println(i);
    }
    @Test
    public void test04(){
        //1073741823
        System.out.println(0x3FFFFFFF);
        //1073741824
        System.out.println(0x4000000000000000L >> 32);
        System.out.println(1073741823 & 1073741824);
        long bitmapIdx = 25;
        System.out.println((0x4000000000000000L | bitmapIdx << 32) >> 32 & 1073741823);
    }
}
