package com.design.pattern.structure.adapter.adapter;

import com.design.pattern.structure.adapter.PayParam;
import com.design.pattern.structure.adapter.payment.AliPay;
import com.design.pattern.structure.adapter.payment.AliPayParam;
import com.design.pattern.structure.adapter.payment.WeChatPay;

import java.util.UUID;

/**
 * 支付宝支付适配器 类适配器 基于组合
 *
 * @author chenpeng
 */
public class AliPayAdapter implements PayAdapter {

    private final AliPay aliPay = new AliPay();
    private final WeChatPay weChatPay = new WeChatPay();

    @Override
    public String pay(PayParam param) {
        boolean pay;
        UUID tradeId = UUID.randomUUID();

        // 获取支付宝证书
        String certificate = "支付宝证书";

        AliPayParam aliPayParam = AliPayParam.builder()
                .account(param.getAccount())
                .mobile(param.getMobile())
                .certificate(certificate)
                .tradeId(tradeId.toString())
                .payMoney(param.getPayMoney())
                .build();
        pay = aliPay.pay(aliPayParam);

        if (pay) {
            return tradeId.toString();
        }
        return "";
    }

    @Override
    public String queryPay(PayParam param) {
        // 获取支付宝证书
        String certificate = "支付宝证书";
        AliPayParam aliPayParam = AliPayParam.builder()
                .certificate(certificate)
                .tradeId(param.getTradeId())
                .build();
        return aliPay.queryPay(aliPayParam);
    }

    @Override
    public String refund(PayParam param) {
        boolean payRefund;
        UUID refundId = UUID.randomUUID();

        // 获取支付宝证书
        String certificate = "支付宝证书";
        AliPayParam aliPayParam = AliPayParam.builder()
                .certificate(certificate)
                .tradeId(param.getTradeId())
                .refundMoney(param.getRefundMoney())
                .build();
        payRefund = aliPay.refund(aliPayParam);

        if (payRefund) {
            return refundId.toString();
        }
        return "";
    }

    @Override
    public String queryRefund(PayParam param) {

        // 获取支付宝证书
        String certificate = "支付宝证书";
        AliPayParam aliPayParam = AliPayParam.builder()
                .certificate(certificate)
                .refundId(param.getRefundId())
                .build();
        return aliPay.queryRefund(aliPayParam);

    }

    @Override
    public String clearing(PayParam param) {
        boolean pay;
        UUID tradeId = UUID.randomUUID();

        // 获取支付宝证书
        String certificate = "支付宝证书";

        AliPayParam aliPayParam = AliPayParam.builder()
                .account(param.getAccount())
                .mobile(param.getMobile())
                .certificate(certificate)
                .tradeId(tradeId.toString())
                .payMoney(param.getPayMoney())
                .clearAccount(param.getClearAccount())
                .build();
        pay = aliPay.payClearing(aliPayParam);

        if (pay) {
            return tradeId.toString();
        }
        return "";
    }
}
