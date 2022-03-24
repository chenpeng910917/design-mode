package com.design.pattern.behavior.template;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 钱包信息
 * @author chenpeng
 */
@Data
public class WalletInfo {

    /**
     * 司机id
     */
    private Long driverId;

    /**
     * 司机收入
     */
    private BigDecimal money;

    // 省略其他信息
}
