package org.example.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.RequestHeaderFrame;
import org.example.process.ProcessFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * HevingHandle 处理请求头
 */
@Component
@Slf4j
public class HevingHandle extends SimpleChannelInboundHandler<RequestHeaderFrame> {//<RequestHeaderFrame>指定处理的数据类型
    @Autowired
    ProcessFactory factory;

    /**
     * channelRead0是
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RequestHeaderFrame msg) throws Exception {
                factory
                    .GetProcess(msg.getFrameType())//根据请求头类型获取处理类
                    .Process(ctx.channel(),msg);//调用处理类处理请求
    }

    /**
     * channelInactive是
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {//
        log.warn("ip ",ctx.channel().localAddress(),"断开");//
    }
}
