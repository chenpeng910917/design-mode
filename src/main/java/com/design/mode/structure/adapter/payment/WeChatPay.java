package com.design.mode.structure.adapter.payment;

import lombok.extern.slf4j.Slf4j;

/**
 * 微信支付(模拟第三方SDK不可改变源码)
 *
 * @author chenpeng
 */
@Slf4j
public class WeChatPay {

    /**
     * 微信支付申请
     *
     * @param param 微信支付申请参数
     * @return 成功/失败
     */
    public boolean pay(WeChatPayParam param) {
        log.info("微信支付申请请求:{}", param);
        return true;
    }

    /**
     * 微信支付结果查询
     *
     * @param param 微信支付结果查询参数
     * @return 支付结果
     */
    public String queryPay(WeChatPayParam param) {
        return "微信交易id:" + param.getTradeId() + "支付成功";
    }

    /**
     * 微信退款申请
     *
     * @param param 微信支付申请参数
     * @return 成功/失败
     */
    public boolean refund(WeChatPayParam param) {
        log.info("微信支付退款申请请求:{}", param);
        return true;
    }

    /**
     * 微信退款结果查询
     * @param param 微信退款结果查询参数
     * @return 退款结果
     */
    public String queryRefund(WeChatPayParam param) {
        return "微信交易id:" + param.getRefundId() + "退款成功";
    }
}
