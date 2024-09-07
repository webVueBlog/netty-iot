package org.example;

import com.sun.corba.se.internal.CosNaming.BootstrapServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.example.spring.SpringLoader;


@Slf4j
public class App {
    private static final String addr = "127.0.0.1";//"127.0.0.1";
    private static final Integer port = 8888;//8888

    public static void main(String[] args) {

        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();// boss线程组
        NioEventLoopGroup eventExecutors1 = new NioEventLoopGroup();// work线程组

        try {
            SpringLoader.Init();// 初始化spring
            StartServer(eventExecutors, eventExecutors1);// 启动服务
        } catch (InterruptedException e) {
            throw new RuntimeException(e);//
        }
    }

    private static void StartServer(NioEventLoopGroup boss, NioEventLoopGroup work) throws InterruptedException {
        ServerBootstrap bootStrap = new ServerBootstrap()// 服务端启动器
                .group(boss, work)// boss线程组和工作线程组
                .channel(NioServerSocketChannel.class)// 服务端通道
                .childHandler(SpringLoader.getBean(ServerInitializer.class));// 子通道处理器
        Channel channel = bootStrap.bind(addr, port)// 绑定端口
                .sync()// 阻塞等待
                .channel();// 获取通道
        log.info("服务启动成功", addr, ":", port);// 打印日志
        channel
                .closeFuture()// 关闭通道
                .sync();// 阻塞等待

    }
}