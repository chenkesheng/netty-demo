package com.cks.netty.bye;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.Unpooled;
import org.junit.jupiter.api.Test;

/**
 * @Author: cks
 * @Date: Created by 14:14 2018/2/26
 * @Package: com.cks.netty.bye
 * @Description:
 */
public class PoolBufTest {
    @Test
    public void pool(){
        ByteBuf data = Unpooled.buffer();
        data.writeBytes("helloWorld".getBytes());
        ByteBuf buf = PooledByteBufAllocator.DEFAULT.buffer(1024);
        buf.writeBytes("helloWorld".getBytes());
        buf.release();
    }
}
