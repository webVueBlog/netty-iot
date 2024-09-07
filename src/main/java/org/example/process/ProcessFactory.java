package org.example.process;

import org.example.entity.CmdTypeEnum;
import org.example.process.strategy.ProcessStrategy;
import org.example.process.strategy.PutParcelStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 策略工厂
 * ProcessFactory
 */
@Service
public class ProcessFactory {
    @Autowired
    private Map<String, ProcessStrategy> strategyMap;// 策略集合

    /**
     * 根据cmd获取策略
     * @param cmd
     * @return
     */
    public ProcessStrategy GetProcess(int cmd) {
        return strategyMap.get(CmdTypeEnum.getStrategyEnum(cmd).getStrategyName());
    }
}
