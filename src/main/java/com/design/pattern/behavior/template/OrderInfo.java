package com.design.pattern.behavior.template;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单信息
 *
 * @author chenpeng
 */
@Data
public class OrderInfo {

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 司机id
     */
    private Long driverId;

    /**
     * 车队
     */
    private Long carTeamId;

    /**
     * 车队类型
     */
    private Long bizType;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 费用
     */
    private BigDecimal cost;

    /**
     * 远程调度费
     */
    private BigDecimal dispatchingFee;

    // 省略其他参数
}
