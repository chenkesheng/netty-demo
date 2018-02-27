package com.cks.netty.client;

import com.alibaba.fastjson.JSONObject;
import com.cks.netty.param.Request;
import com.cks.user.model.User;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.AttributeKey;

/**
 * @Author: cks
 * @Date: Created by 上午11:58 2018/2/16
 * @Package: com.cks.netty.client
 * @Description: netty 客户端
 */
public class NettyClient {
    //    public static EventLoopGroup eventLoopGroup;
//    public static Bootstrap bootstrap;
//    static {
//        eventLoopGroup = new NioEventLoopGroup();
//        bootstrap = new Bootstrap();
//
//        bootstrap.channel(NioSocketChannel.class);
//        bootstrap.group(eventLoopGroup);
//        bootstrap.option(ChannelOption.ALLOCATOR,PooledByteBufAllocator.DEFAULT);
////        bootstrap.option(ChannelOption.RCVBUF_ALLOCATOR, AdaptiveRecvByteBufAllocator.DEFAULT);
//        bootstrap.option(ChannelOption.SO_KEEPALIVE, true)
//                .handler(new ChannelInitializer<SocketChannel>() {
//                    protected void initChannel(SocketChannel socketChannel) throws Exception {
//                        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
//                        socketChannel.pipeline().addLast(new StringDecoder());
//                        socketChannel.pipeline().addLast(new ClientHandler());
//                        //字符编码，否则要把字符串转出bufBytes
//                        socketChannel.pipeline().addLast(new StringEncoder());
//                    }
//                });
//    }
//    public static void main(String[] args) {
//        try {
//            ChannelFuture channelFuture = bootstrap.connect("localhost", 8080).sync();
//            String person = "我是陈克圣\r\n";
//            channelFuture.channel().writeAndFlush(person);
////            Thread.sleep(5000);
////            channelFuture.channel().writeAndFlush(Delimiters.lineDelimiter()[0]);
//            //这代表的上短链接
//            channelFuture.channel().closeFuture().sync();
//            Object result = channelFuture.channel().attr(AttributeKey.valueOf("ChannelKey")).get();
//            System.out.println(result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            eventLoopGroup.shutdownGracefully();
//        }
//    }
    public static EventLoopGroup group = null;
    public static Bootstrap bootstrap = null;

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
                        //解码
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new ClientHandler());
                        //字符编码，否则要把字符串转出bufBytes
                        ch.pipeline().addLast(new StringEncoder());
                    }
                });
//		bootstrap.option(ChannelOption.RCVBUF_ALLOCATOR,AdaptiveRecvByteBufAllocator.DEFAULT);
    }

    public static void main(String[] args) {

        try {
            ChannelFuture future = bootstrap.connect("localhost", 8080).sync();

            User user = new User();
            user.setAge("11");
            user.setId(1);
            user.setName("张三");

            Request request = new Request();
            request.setCommand("saveUser");
            request.setContent(user);
            future.channel().writeAndFlush(JSONObject.toJSONString(request));
            future.channel().writeAndFlush("\r\n");
            future.channel().closeFuture().sync();
            Object result = future.channel().attr(AttributeKey.valueOf("ChannelKey")).get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }


    }
}
