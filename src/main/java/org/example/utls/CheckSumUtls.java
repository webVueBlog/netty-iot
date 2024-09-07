package org.example.utls;

/**
 * CheckSumUtls 类用于计算校验和
 */
public final class CheckSumUtls {
    public static int CheckSum(byte[] data) {//计算校验和
        // 在实际应用中，你应该使用更强大的校验和算法
        int checksum = 0;
        for (byte b : data) {
            checksum += b;
        }
        return checksum;
    }

}
