package org.example.process.strategy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.Channel;
import io.netty.channel.socket.SocketChannel;

import org.example.cache.CacheService;
import org.example.entity.CmdTypeEnum;
import org.example.entity.RequestHeaderFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 存放包裹处理策略
 */
@Service("PutParcelStrategy")
public class PutParcelStrategy implements ProcessStrategy{
    private int UIDLENGTH=8;//用户ID长度
    private int PUTID=8;//存放ID长度
    private int PACKGEID=16;//包裹ID长度

    @Autowired
    CacheService service;

    /**
     * Process表示
     * @param channel
     * @param frame
     */
    @Override
    public void Process(Channel channel, RequestHeaderFrame frame) {
        ByteBuf buf = frame.getData();//获取数据
        byte[] uidArray= new byte[UIDLENGTH];//用户ID
        buf.readBytes(uidArray);//读取用户ID
        byte[] putArray= new byte[UIDLENGTH];//存放ID
        buf.readBytes(putArray);//读取存放ID
        byte[] packageIdArray= new byte[PACKGEID];//包裹ID
        buf.readBytes(packageIdArray);//读取包裹ID
    }
}
