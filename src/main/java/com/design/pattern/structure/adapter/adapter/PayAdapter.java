package com.design.pattern.structure.adapter.adapter;

import com.design.pattern.structure.adapter.PayParam;

/**
 * 支付适配器接口
 *
 * @author chenpeng
 */
public interface PayAdapter {
    /**
     * 支付申请
     *
     * @param param 微信支付申请参数
     * @return 支付交易id
     */
    String pay(PayParam param);

    /**
     * 支付结果查询
     *
     * @param param 支付结果查询参数
     * @return 支付结果
     */
    String queryPay(PayParam param);

    /**
     * 退款申请
     *
     * @param param 支付申请参数
     * @return 退款交易id
     */
    String refund(PayParam param);

    /**
     * 退款结果查询
     *
     * @param param 退款结果查询参数
     * @return 退款结果
     */
    String queryRefund(PayParam param);

    /**
     * 清算 只支持支付宝
     * @return 清算结果
     */
    String clearing(PayParam param);
}
