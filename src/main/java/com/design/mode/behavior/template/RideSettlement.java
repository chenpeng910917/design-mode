package com.design.mode.behavior.template;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 网约车结算
 *
 * @author chenpeng
 */
@Slf4j
public class RideSettlement extends AbstractSettlementTemplate {

    @Override
    public void check(Context context) {
        OrderInfo orderInfo = context.getOrderInfo();
        if (orderInfo.getTenantId() == null) {
            log.info("租户id不能为空");
        }
        if (orderInfo.getOrderId() == null) {
            log.info("订单id不能为空");
        }
        if (orderInfo.getDriverId() == null) {
            log.info("司机id不能为空");
        }
    }

    @Override
    public WalletInfo calculation(Context context) {
        OrderInfo orderInfo = context.getOrderInfo();
        SnapshotRuleInfo snapshotRuleInfo = context.getSnapshotRuleInfo();
        // 费用
        BigDecimal cost = orderInfo.getCost();
        // 应得的费用
        BigDecimal deservedCost = cost.multiply(BigDecimal.valueOf(snapshotRuleInfo.getDriverRatio())).multiply(ONE_PERCENT);
        WalletInfo walletInfo = new WalletInfo();
        walletInfo.setMoney(deservedCost);
        walletInfo.setDriverId(orderInfo.getDriverId());
        return walletInfo;
    }
}
