package com.cks.netty.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

import java.nio.charset.Charset;

import com.alibaba.fastjson.JSONObject;
import com.cks.netty.Media;
import com.cks.netty.param.RequestParam;

/**
 * @Author: cks
 * @Date: Created by 下午14:35 2018/2/27
 * @Package: com.cks.netty.http
 * @Description: HttpServerHandler
 */
public class HttpServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        try {
            if (msg instanceof FullHttpRequest) {
                FullHttpRequest req = (FullHttpRequest) msg;
                //获取请求内容
                String content = req.content().toString(Charset.defaultCharset());
                RequestParam request = JSONObject.parseObject(content, RequestParam.class);
                Object result = Media.execute(request);

                DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                        HttpResponseStatus.OK, Unpooled.wrappedBuffer(JSONObject.toJSONString(result).getBytes(Charset.defaultCharset())));
                //请求的数据格式
                response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
                //返回字符串
                response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
                //保持连接可用
                response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
                ctx.channel().writeAndFlush(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ctx.channel().writeAndFlush("");
        }
    }
}
