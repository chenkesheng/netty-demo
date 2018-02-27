package com.cks.netty.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;

import java.nio.charset.Charset;
/**
 * @Author: cks
 * @Date: Created by 下午14:35 2018/2/27
 * @Package: com.cks.netty.client
 * @Description: HttpClientHandler
 */
public class HttpClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        if (msg instanceof HttpResponse) {
            HttpResponse res = (HttpResponse) msg;
            if (res.status() == HttpResponseStatus.OK) {
            }
        }

        if (msg instanceof HttpContent) {
            HttpContent content = (HttpContent) msg;
            String result = content.content().toString(Charset.defaultCharset());
            System.out.println(result);
            ctx.channel().close();
        }
    }
}
