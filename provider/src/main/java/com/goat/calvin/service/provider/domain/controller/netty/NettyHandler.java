package com.goat.calvin.service.provider.domain.controller.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * @author xiefei
 * @date 2022/4/24 14:32
 */
public class NettyHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取客户端发送的消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器线程：" + Thread.currentThread().getName());
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端发送的消息：" + msg);
    }

    /**
     * 连接信息
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接服务端成功！");
        super.channelActive(ctx);
    }

    /**
     * 读取客户端消息并且回复
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf = Unpooled.copiedBuffer("helloClient", CharsetUtil.UTF_8);
        ctx.writeAndFlush(buf);
    }
}
