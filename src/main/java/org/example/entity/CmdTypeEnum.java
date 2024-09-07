package org.example.entity;

import lombok.Data;
import org.example.process.strategy.PutParcelStrategy;

/**
 * CmdTypeEnum 枚举类
 */
public enum CmdTypeEnum {
    PutParcel(100, PutParcelStrategy.class.getName());//放入包裹

    private String strategyName;// 策略名称
    private Integer cmd;// 策略code

    /**
     * getStrategyName 获取
     * @return
     */
    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public Integer getCmd() {
        return cmd;
    }

    public void setCmd(Integer cmd) {
        this.cmd = cmd;
    }

    CmdTypeEnum(Integer code, String strategyName) {
        this.strategyName = strategyName;
        this.cmd = code;
    }

    public static CmdTypeEnum getStrategyEnum(int code) {
        CmdTypeEnum[] payChannelStrategyEnums = CmdTypeEnum.values();
        CmdTypeEnum result = null;
        for (CmdTypeEnum payChannelStrategyEnum : payChannelStrategyEnums) {
            if (payChannelStrategyEnum.getCmd() == code) {
                result = payChannelStrategyEnum;
                break;
            }
        }
        return result;
    }

}
