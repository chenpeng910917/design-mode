package com.design.mode.structure.adapter.adapter;

import com.design.mode.structure.adapter.PayParam;
import com.design.mode.structure.adapter.PayTypeEnum;
import com.design.mode.structure.adapter.payment.AliPay;
import com.design.mode.structure.adapter.payment.AliPayParam;
import com.design.mode.structure.adapter.payment.WeChatPay;
import com.design.mode.structure.adapter.payment.WeChatPayParam;

import java.util.UUID;

/**
 * 微信支付适配器 类适配器 基于组合
 *
 * @author chenpeng
 */
public class WeChatPayAdapter implements PayAdapter {

    private final WeChatPay weChatPay = new WeChatPay();

    @Override
    public String pay(PayParam param) {
        boolean pay;
        UUID tradeId = UUID.randomUUID();
        // 微信支付
        String secretKey = "微信密钥";
        WeChatPayParam weChatPayParam = WeChatPayParam.builder()
                .account(param.getAccount())
                .mobile(param.getMobile())
                .secretKey(secretKey)
                .tradeId(tradeId.toString())
                .payMoney(param.getPayMoney())
                .build();
        pay = weChatPay.pay(weChatPayParam);


        if (pay) {
            return tradeId.toString();
        }
        return "";
    }

    @Override
    public String queryPay(PayParam param) {
        // 获取微信密钥
        String secretKey = "微信密钥";
        UUID uuid = UUID.randomUUID();
        WeChatPayParam weChatPayParam = WeChatPayParam.builder()
                .secretKey(secretKey)
                .tradeId(uuid.toString())
                .build();
        return weChatPay.queryPay(weChatPayParam);

    }

    @Override
    public String refund(PayParam param) {
        boolean payRefund;
        UUID refundId = UUID.randomUUID();
        // 获取微信密钥
        String secretKey = "微信密钥";
        WeChatPayParam weChatPayParam = WeChatPayParam.builder()
                .secretKey(secretKey)
                .tradeId(param.getTradeId())
                .refundMoney(param.getRefundMoney())
                .build();
        payRefund = weChatPay.refund(weChatPayParam);

        if (payRefund) {
            return refundId.toString();
        }
        return "";
    }

    @Override
    public String queryRefund(PayParam param) {
        // 获取微信密钥
        String secretKey = "微信密钥";
        WeChatPayParam weChatPayParam = WeChatPayParam.builder()
                .secretKey(secretKey)
                .refundId(param.getRefundId())
                .build();
        return weChatPay.queryRefund(weChatPayParam);

    }

    @Override
    public String clearing(PayParam param) {
        throw new RuntimeException("微信不支持清算支付");
    }
}
