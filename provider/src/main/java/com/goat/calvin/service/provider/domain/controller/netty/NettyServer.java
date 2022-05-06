package com.goat.calvin.service.provider.domain.controller.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author xiefei
 * @date 2022/4/24 14:32
 */
public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        //创建两个线程组bossGroup和workerGroup, 含有的子线程NioEventLoop的个数默认为cpu核数的两倍
        // bossGroup只是处理连接请求 ,真正的和客户端业务处理，会交给workerGroup完成
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        // 创建服务端启动对象
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1204)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    // 创建通道初始化对象，设置初始化参数
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        // 对指定通道指定处理器
                        socketChannel.pipeline().addLast(new NettyHandler());
                    }
                });
        System.out.println("netty server start ...");

        // 启动并访问端口
        try {
            ChannelFuture sync = serverBootstrap.bind(9000).sync();
            if (sync.isSuccess()) {
                System.out.println("netty server started!");
            }
        } finally {
            // 最后关闭
//            bossGroup.shutdownGracefully();
//            workGroup.shutdownGracefully();
        }
    }

}
