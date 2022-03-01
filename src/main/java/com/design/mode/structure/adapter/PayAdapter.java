package com.design.mode.structure.adapter;

import com.design.mode.structure.adapter.payment.AliPay;
import com.design.mode.structure.adapter.payment.AliPayParam;
import com.design.mode.structure.adapter.payment.WeChatPay;
import com.design.mode.structure.adapter.payment.WeChatPayParam;

import java.util.UUID;

/**
 * 支付适配器 类适配器 基于组合
 *
 * @author chenpeng
 */
public class PayAdapter implements Pay {

    private final AliPay aliPay = new AliPay();
    private final WeChatPay weChatPay = new WeChatPay();

    @Override
    public String pay(PayParam param) {
        boolean pay;
        UUID tradeId = UUID.randomUUID();
        // 支付宝支付
        if (param.getPayType().equals(PayTypeEnum.ALI.getType())) {
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
        }
        // 微信支付
        else if (param.getPayType().equals(PayTypeEnum.WECHAT.getType())) {
            // 获取微信密钥
            String secretKey = "微信密钥";
            WeChatPayParam weChatPayParam = WeChatPayParam.builder()
                    .account(param.getAccount())
                    .mobile(param.getMobile())
                    .secretKey(secretKey)
                    .tradeId(tradeId.toString())
                    .payMoney(param.getPayMoney())
                    .build();
            pay = weChatPay.pay(weChatPayParam);
        } else {
            throw new IllegalArgumentException("不支持的支付类型");
        }

        if (pay) {
            return tradeId.toString();
        }
        return "";
    }

    @Override
    public String queryPay(PayParam param) {
        // 支付宝支付
        if (param.getPayType().equals(PayTypeEnum.ALI.getType())) {
            // 获取支付宝证书
            String certificate = "支付宝证书";
            AliPayParam aliPayParam = AliPayParam.builder()
                    .certificate(certificate)
                    .tradeId(param.getTradeId())
                    .build();
            return aliPay.queryPay(aliPayParam);
        }
        // 微信支付
        else if (param.getPayType().equals(PayTypeEnum.WECHAT.getType())) {
            // 获取微信密钥
            String secretKey = "微信密钥";
            UUID uuid = UUID.randomUUID();
            WeChatPayParam weChatPayParam = WeChatPayParam.builder()
                    .secretKey(secretKey)
                    .tradeId(uuid.toString())
                    .build();
            return weChatPay.queryPay(weChatPayParam);
        } else {
            throw new IllegalArgumentException("不支持的支付类型");
        }
    }

    @Override
    public String refund(PayParam param) {
        boolean payRefund;
        UUID refundId = UUID.randomUUID();
        // 支付宝支付
        if (param.getPayType().equals(PayTypeEnum.ALI.getType())) {
            // 获取支付宝证书
            String certificate = "支付宝证书";
            AliPayParam aliPayParam = AliPayParam.builder()
                    .certificate(certificate)
                    .tradeId(param.getTradeId())
                    .refundMoney(param.getRefundMoney())
                    .build();
            payRefund = aliPay.refund(aliPayParam);
        }
        // 微信支付
        else if (param.getPayType().equals(PayTypeEnum.WECHAT.getType())) {
            // 获取微信密钥
            String secretKey = "微信密钥";
            WeChatPayParam weChatPayParam = WeChatPayParam.builder()
                    .secretKey(secretKey)
                    .tradeId(param.getTradeId())
                    .refundMoney(param.getRefundMoney())
                    .build();
            payRefund = weChatPay.refund(weChatPayParam);
        } else {
            throw new IllegalArgumentException("不支持的支付类型");
        }

        if (payRefund) {
            return refundId.toString();
        }
        return "";
    }

    @Override
    public String queryRefund(PayParam param) {
        // 支付宝支付
        if (param.getPayType().equals(PayTypeEnum.ALI.getType())) {
            // 获取支付宝证书
            String certificate = "支付宝证书";
            AliPayParam aliPayParam = AliPayParam.builder()
                    .certificate(certificate)
                    .refundId(param.getRefundId())
                    .build();
            return aliPay.queryRefund(aliPayParam);
        }
        // 微信支付
        else if (param.getPayType().equals(PayTypeEnum.WECHAT.getType())) {
            // 获取微信密钥
            String secretKey = "微信密钥";
            WeChatPayParam weChatPayParam = WeChatPayParam.builder()
                    .secretKey(secretKey)
                    .refundId(param.getRefundId())
                    .build();
            return weChatPay.queryRefund(weChatPayParam);
        } else {
            throw new IllegalArgumentException("不支持的支付类型");
        }
    }

    @Override
    public String clearing(PayParam param) {
        boolean pay;
        UUID tradeId = UUID.randomUUID();
        // 支付宝支付
        if (param.getPayType().equals(PayTypeEnum.ALI.getType())) {
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
        } else {
            throw new IllegalArgumentException("不支持的支付类型");
        }
        if (pay) {
            return tradeId.toString();
        }
        return "";
    }
}
