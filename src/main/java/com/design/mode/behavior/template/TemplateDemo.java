package com.design.mode.behavior.template;

import java.math.BigDecimal;

/**
 * 模板模式例子
 *
 * @author chenpeng
 */
public class TemplateDemo {
    public static void main(String[] args) {
        Context context = new Context();

        // 网约车
        RideSettlement rideSettlement = new RideSettlement();

        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId("111111");
        orderInfo.setBizType(300L);
        orderInfo.setDriverId(100000L);
        orderInfo.setTenantId(1L);
        orderInfo.setCost(BigDecimal.valueOf(100));
        orderInfo.setCarTeamId(123L);
        context.setOrderInfo(orderInfo);
        // 执行模板方法
        rideSettlement.templateMethod(context);

        // 巡改网
        CruiseSettlement cruiseSettlement = new CruiseSettlement();

        OrderInfo cruiseOrderInfo = new OrderInfo();
        cruiseOrderInfo.setOrderId("2222");
        cruiseOrderInfo.setBizType(302L);
        cruiseOrderInfo.setDriverId(200000L);
        cruiseOrderInfo.setTenantId(800011L);
        cruiseOrderInfo.setCost(BigDecimal.valueOf(90));
        cruiseOrderInfo.setCarTeamId(456L);
        cruiseOrderInfo.setDispatchingFee(BigDecimal.valueOf(10));
        context.setOrderInfo(cruiseOrderInfo);
        // 执行模板方法
        cruiseSettlement.templateMethod(context);
    }
}
