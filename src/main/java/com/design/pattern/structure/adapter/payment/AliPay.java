package com.design.pattern.structure.adapter.payment;

import lombok.extern.slf4j.Slf4j;

/**
 * 支付宝支付(模拟第三方SDK不可改变源码)
 *
 * @author chenpeng
 */
@Slf4j
public class AliPay {
    /**
     * 支付宝支付申请
     *
     * @param param 支付宝支付申请参数
     * @return 成功/失败
     */
    public boolean pay(AliPayParam param) {
        log.info("支付宝支付申请请求:{}", param);
        return true;
    }

    public boolean payClearing(AliPayParam param){
        log.info("支付宝清算支付申请请求:{}", param);
        return true;
    }

    /**
     * 支付宝支付结果查询
     *
     * @param param 支付宝支付结果查询参数
     * @return 支付结果
     */
    public String queryPay(AliPayParam param) {
        return "支付宝交易id:" + param.getTradeId() + "支付成功";
    }

    /**
     * 支付宝退款申请
     *
     * @param param 支付宝支付申请参数
     * @return 成功/失败
     */
    public boolean refund(AliPayParam param) {
        log.info("支付宝支付退款申请请求:{}", param);
        return true;
    }

    /**
     * 支付宝退款结果查询
     * @param param 支付宝退款接口查询参数
     * @return 退款结果
     */
    public String queryRefund(AliPayParam param) {
        return "支付宝交易id:" + param.getRefundId() + "退款成功";
    }
}
