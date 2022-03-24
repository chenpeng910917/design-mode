package com.design.pattern.structure.adapter.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 微信支付参数
 *
 * @author chenpeng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeChatPayParam {

    /**
     * 微信支付账户
     */
    private String account;

    /**
     * 微信支付手机号
     */
    private String mobile;

    /**
     * 微信支付密钥
     */
    private String secretKey;

    /**
     * 交易id
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
}
