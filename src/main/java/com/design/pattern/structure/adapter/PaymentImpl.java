package com.design.pattern.structure.adapter;

import com.design.pattern.structure.adapter.payment.PayFactory;

/**
 * 支付接口实现
 *
 * @author chenpeng
 */
public class PaymentImpl implements Payment {
    @Override
    public String pay(PayParam param) {
        Payment pay = PayFactory.getPay(param.getPayType());
        return pay.pay(param);
    }

    @Override
    public String queryPay(PayParam param) {
        Payment pay = PayFactory.getPay(param.getPayType());
        return pay.queryPay(param);
    }

    @Override
    public String refund(PayParam param) {
        Payment pay = PayFactory.getPay(param.getPayType());
        return pay.refund(param);
    }

    @Override
    public String queryRefund(PayParam param) {
        Payment pay = PayFactory.getPay(param.getPayType());
        return pay.queryRefund(param);
    }

    @Override
    public String clearing(PayParam param) {
        Payment pay = PayFactory.getPay(param.getPayType());
        return pay.clearing(param);
    }
}
