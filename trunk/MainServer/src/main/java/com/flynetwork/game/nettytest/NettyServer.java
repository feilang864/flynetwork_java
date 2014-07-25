/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flynetwork.game.nettytest;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

    private int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void run() throws Exception {
        //NioEventLoopGroup是一个多线程的I/O操作事件循环池(参数是线程数量)
        //bossGroup主要用于接受所有客户端对服务端的连接
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //当有新的连接进来时将会被注册到workerGroup(不提供参数，会使用默认的线程数)
        EventLoopGroup workerGroup = new NioEventLoopGroup(1);
        try {
            //ServerBootstrap是设置服务器的辅助类
            ServerBootstrap bs = new ServerBootstrap();
            //group方法是将上面创建的两个EventLoopGroup实例指定到ServerBootstrap实例中去
            bs.group(bossGroup, workerGroup)
                    //channel方法用来创建通道实例(NioServerSocketChannel类来实例化一个进来的连接)
                    .channel(NioServerSocketChannel.class)
                    //为新连接到服务器的handler分配一个新的channel。ChannelInitializer用来配置新生成的channel。(如需其他的处理，继续ch.pipeline().addLast(新匿名handler对象)即可)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) throws Exception {
                            //处理逻辑放到SocketHandler类中去
                            ch.pipeline()
                            .addLast("frameDecoder", new NettyDecoder())
                            .addLast("frameEncoder", new NettyEncoder())
                            .addLast("handler", new NettyServerHandler());
                        }
                    })
                    //option()方法用于设置监听套接字
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //childOption()方法用于设置和客户端连接的套接字
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // Bind and start to accept incoming connections
            ChannelFuture cf = bs.bind(this.port).sync();
            // Wait until the session socket is closed.
            // shut down your session.
            cf.channel().closeFuture().sync();
            ///发送消息
            //cf.channel().writeAndFlush(cf);
        } finally {
            //关闭相关资源
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new NettyServer(9999).run();
    }

}
