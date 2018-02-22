package com.cks.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;

/**
 * @Author: cks
 * @Date: Created by 下午9:41 2018/2/16
 * @Package: com.cks.netty.client
 * @Description:
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    public void channelRead(ChannelHandlerContext context, Object msg) throws Exception {
        //在通道下加各种属性值
        context.channel().attr(AttributeKey.valueOf("ChannelKey")).set(msg.toString());
        context.channel().close();
    }
}
