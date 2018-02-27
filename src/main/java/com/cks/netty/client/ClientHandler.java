package com.cks.netty.client;

import com.alibaba.fastjson.JSONObject;
import com.cks.netty.core.DefaultFuture;
import com.cks.netty.param.Response;
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
    public void channelRead(ChannelHandlerContext context, Object msg) {
        if(msg.toString().equals("ping")){
            context.channel().writeAndFlush("ping\r\n");
            return ;
        }
        System.out.println("客户端返回数据==="+msg.toString());
        Response res = JSONObject.parseObject(msg.toString(), Response.class);
        DefaultFuture.receive(res);
        //在通道下加各种属性值
//        context.channel().attr(AttributeKey.valueOf("ChannelKey")).set(msg.toString());
//        context.channel().close();
    }
}
