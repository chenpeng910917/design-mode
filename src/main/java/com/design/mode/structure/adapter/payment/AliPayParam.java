package com.design.mode.structure.adapter.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 支付宝支付参数
 * @author chenpeng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AliPayParam {

    /**
     * 支付宝支付账户
     */
    private String account;

    /**
     * 支付宝支付手机号
     */
    private String mobile;

    /**
     * 支付宝支付证书
     */
    private String certificate;

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
