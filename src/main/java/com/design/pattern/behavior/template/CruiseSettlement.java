package com.design.pattern.behavior.template;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 巡改网结算
 *
 * @author chenpeng
 */
@Slf4j
public class CruiseSettlement extends AbstractSettlementTemplate {

    /**
     * 巡改网租户
     */
    private final Long TENANT_ID = 800011L;

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
        if (!TENANT_ID.equals(orderInfo.getTenantId())) {
            log.error("此租户:{}不是巡改网租户", orderInfo.getTenantId());
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
        // 巡改网加上远程调度费
        BigDecimal income = deservedCost.add(orderInfo.getDispatchingFee());
        WalletInfo walletInfo = new WalletInfo();
        walletInfo.setMoney(income);
        walletInfo.setDriverId(orderInfo.getDriverId());
        return walletInfo;
    }
}
