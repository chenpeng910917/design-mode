package com.design.mode.structure.adapter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 支付参数
 *
 * @author chenpeng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayParam {

    /**
     * 支付类型
     * {@link PayTypeEnum}
     */
    private Integer payType;

    /**
     * 支付账户
     */
    private String account;

    /**
     * 支付手机号
     */
    private String mobile;

    /**
     * 支付交易id
     */
    private String tradeId;

    /**
     * 退款交易id
     */
    private String refundId;

    /**
     * 支付金额
     */
    private BigDecimal payMoney;

    /**
     * 退款金额
     */
    private BigDecimal refundMoney;

    /**
     * 清算账户
     */
    private List<String> clearAccount;
}
