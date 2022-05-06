package com.goat.calvin.service.provider.domain.controller.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author xiefei
 * @date 2022/4/24 14:32
 */
public class NettyClient {
    public static void main(String[] args) {
        // 创建一个时间循环组来接收
        NioEventLoopGroup group = new NioEventLoopGroup();

        // 创建客户端启动对象
        Bootstrap bootstrap = new Bootstrap();
        // 绑定事件组
        bootstrap.group(group)
                // 指定管道信息
                .channel(NioSocketChannel.class)
                // 指定处理器
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new NettyHandler());
                    }
                });
        System.out.println("netty client start...");

        try {
            ChannelFuture sync = bootstrap.connect("127.0.0.1", 9000).sync();
            // 启动管道监听
            sync.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //group.shutdownGracefully();
        }
    }
}
