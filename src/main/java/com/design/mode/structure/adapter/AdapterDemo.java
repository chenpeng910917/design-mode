package com.design.mode.structure.adapter;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

/**
 * 适配器模式例子  统一多个类的接口设计
 *
 * @author chenpeng
 */
public class AdapterDemo {

    public static void main(String[] args) {
        // 支付参数
        PayParam payParam = PayParam.builder()
                .payType(PayTypeEnum.WECHAT.getType())
                .account("2345235")
                .mobile("123123123")
                .payMoney(new BigDecimal(120))
                .build();

        // 适配器
        Pay payAdapter = new PayAdapter();
        // 支付
        String pay = payAdapter.pay(payParam);
        System.out.println("支付申请交易id：" + pay);

        // 清算支付
        List<String> list = Lists.newArrayList();
        list.add("123");
        list.add("345");
        payParam.setClearAccount(list);
        String clearing = payAdapter.clearing(payParam);
        System.out.println("清算支付交易id：" + clearing);

        // 支付查询
        payParam.setTradeId(pay);
        String queryPay = payAdapter.queryPay(payParam);
        System.out.println("支付查询结果：" + queryPay);

        // 退款
        payParam.setRefundMoney(new BigDecimal(100));
        String refund = payAdapter.refund(payParam);
        System.out.println("退款申请退款交易id：" + refund);

        // 退款查询
        payParam.setRefundId(refund);
        String queryRefund = payAdapter.queryRefund(payParam);
        System.out.println("退款查询结果" + queryRefund);
    }
}