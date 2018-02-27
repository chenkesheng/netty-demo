package com.cks.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import com.alibaba.fastjson.JSONObject;
import com.cks.netty.core.DefaultFuture;
import com.cks.netty.param.Request;
import com.cks.netty.param.Response;

public class TcpClient {
    public static EventLoopGroup group;
    public static Bootstrap bootstrap;
    public static ChannelFuture future = null;

    static {
        group = new NioEventLoopGroup();
        bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.group(group);
        bootstrap.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new DelimiterBasedFrameDecoder
                                (Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new ClientHandler());
                        ch.pipeline().addLast(new StringEncoder());


                    }
                });
        try {
            future = bootstrap.connect("localhost", 8080).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//		bootstrap.option(ChannelOption.RCVBUF_ALLOCATOR,AdaptiveRecvByteBufAllocator.DEFAULT);
    }

    public static Object send(Request request) {

        try {
            future.channel().writeAndFlush(JSONObject.toJSONString(request));
            future.channel().writeAndFlush("\r\n");
            DefaultFuture defaultFuture = new DefaultFuture(request);
            Response response = defaultFuture.get(10);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
