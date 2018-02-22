package com.cks.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
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
    public static EventLoopGroup eventLoopGroup = null;
    public static Bootstrap bootstrap = null;
    static {
        eventLoopGroup = new NioEventLoopGroup();
        bootstrap = new Bootstrap();

        bootstrap.channel(NioSocketChannel.class);
        bootstrap.group(eventLoopGroup);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, Delimiters.lineDelimiter()[0]));
                        socketChannel.pipeline().addLast(new StringDecoder());
                        socketChannel.pipeline().addLast(new ClientHandler());
                        //字符编码，否则要把字符串转出bufBytes
                        socketChannel.pipeline().addLast(new StringEncoder());
                    }
                });
    }
    public static void main(String[] args) {
        try {
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8080).sync();
            String person = "我是陈克圣\r\n";
            channelFuture.channel().writeAndFlush(person);
//            channelFuture.channel().writeAndFlush(Delimiters.lineDelimiter()[0]);
            //这代表的上短链接
            channelFuture.channel().closeFuture().sync();
            Object result = channelFuture.channel().attr(AttributeKey.valueOf("ChannelKey")).get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }
}
