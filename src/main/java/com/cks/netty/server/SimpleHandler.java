package com.cks.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.EventExecutorGroup;

import java.nio.charset.Charset;

/**
 * @Author: cks
 * @Date: Created by 下午4:43 2018/2/16
 * @Package: com.cks.netty.server
 * @Description:
 */
public class SimpleHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {

        System.out.println("开始读取数据============");
        if (msg instanceof ByteBuf) {
            ByteBuf req = (ByteBuf)msg;
            String content = req.toString(Charset.defaultCharset());
            System.out.println(content);
            System.out.println("开始发送数据============");
            String name = "我是花蕾\r\n";
            ctx.channel().writeAndFlush(name);

//            RequestParam request = JSONObject.parseObject(content,RequestParam.class);
//            Object result = Media.execute(request);
//
//            Response res = new Response();
//            res.setId(request.getId());
//            res.setContent(result);
//            ctx.channel().write(JSONObject.toJSONString(res));
//            ctx.channel().writeAndFlush("\r\n");
        }


    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        // TODO Auto-generated method stub
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx)
            throws Exception {
        super.channelWritabilityChanged(ctx);
    }


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt)
            throws Exception {
//
//        if(evt instanceof IdleStateEvent){
//            IdleStateEvent event = (IdleStateEvent)evt;
//            if(event.equals(IdleState.READER_IDLE)){
//                System.out.println("读空闲====");
//                ctx.close();
//            }else if(event.equals(IdleState.WRITER_IDLE)){
//                System.out.println("写空闲====");
//            }else if(event.equals(IdleState.WRITER_IDLE)){
//                System.out.println("读写空闲====");
//                ctx.channel().writeAndFlush("ping\r\n");
//            }
//
//        }
//
//        super.userEventTriggered(ctx, evt);
    }
}
