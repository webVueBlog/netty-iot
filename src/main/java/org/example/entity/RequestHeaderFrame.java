package org.example.entity;

import io.netty.buffer.ByteBuf;
import lombok.Data;
import lombok.ToString;

/**
 * RequestHeaderFrame 请求头
 */
@Data
public class RequestHeaderFrame {
    final byte[] frameHeader = {(byte) 0xAA, (byte) 0xBB};// 帧头
    byte frameType;// 帧类型
    short dataLength;// 数据长度
    long longitude;// 经度
    long latitude;// 纬度
    byte[] cabinetId = new byte[16];// 柜子id
    ByteBuf data;// 数据
    int checksum;// 校验和
}
