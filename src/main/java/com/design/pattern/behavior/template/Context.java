package com.design.pattern.behavior.template;

import lombok.Data;

/**
 * 结算上下文信息
 *
 * @author chenpeng
 */
@Data
public class Context {

    /**
     * 订单数据
     */
    private OrderInfo orderInfo;

    /**
     * 抽佣数据
     */
    private SnapshotRuleInfo snapshotRuleInfo;
}
