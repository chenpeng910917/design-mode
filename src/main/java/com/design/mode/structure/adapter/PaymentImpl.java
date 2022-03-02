package com.design.mode.structure.adapter;

import com.design.mode.structure.adapter.adapter.PayAdapter;
import com.design.mode.structure.adapter.payment.PayFactory;

/**
 * 支付接口实现
 *
 * @author chenpeng
 */
public class PaymentImpl implements Payment {
    @Override
    public String pay(PayParam param) {
        PayAdapter pay = PayFactory.getPay(param.getPayType());
        return pay.pay(param);
    }

    @Override
    public String queryPay(PayParam param) {
        PayAdapter pay = PayFactory.getPay(param.getPayType());
        return pay.queryPay(param);
    }

    @Override
    public String refund(PayParam param) {
        PayAdapter pay = PayFactory.getPay(param.getPayType());
        return pay.refund(param);
    }

    @Override
    public String queryRefund(PayParam param) {
        PayAdapter pay = PayFactory.getPay(param.getPayType());
        return pay.queryRefund(param);
    }

    @Override
    public String clearing(PayParam param) {
        PayAdapter pay = PayFactory.getPay(param.getPayType());
        return pay.clearing(param);
    }
}
