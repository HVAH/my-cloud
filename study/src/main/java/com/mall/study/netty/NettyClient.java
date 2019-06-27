package com.mall.study.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/6/25 16:41
 * @Version 1.0
 **/
public class NettyClient implements Runnable{
    public static void main(String[] args) {
        int count = 0;
        while (count < 100) {
            new Thread(new NettyClient()).start();
            count++;
        }
    }

    public void send(String msg) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                });

        Channel channel = bootstrap.connect("127.0.0.1", 8000).channel();

        while (true) {
            channel.writeAndFlush(new Date() + " : " + msg  + " : hello world!");
            Thread.sleep(10);
        }
    }

    @Override
    public void run() {
        try {
            this.send(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


