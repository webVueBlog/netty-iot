package org.example.process.strategy;

import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;
import org.example.entity.RequestHeaderFrame;

/**
 * ProcessStrategy 接口
 */
public interface ProcessStrategy {
    void  Process(Channel channel, RequestHeaderFrame frame);// 处理请求
}
