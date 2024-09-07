package org.example;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import org.example.codec.HeaderFrameDecoder;
import org.example.codec.HeaderFrameEncoder;
import org.example.handle.HevingHandle;
import org.example.spring.SpringLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ServerInitializer 初始化器
 */
@Component
public class ServerInitializer extends ChannelInitializer {//
    @Autowired
    HevingHandle hevingHandle;//

    // initChannel
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()//
                .addLast(SpringLoader.getBean(HeaderFrameDecoder.class))// 添加解码器
                .addLast(SpringLoader.getBean(HeaderFrameEncoder.class))/// 添加编码器
                .addLast(hevingHandle);// 添加处理器
    }
}
