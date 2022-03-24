package com.design.pattern.behavior.template;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * 结算模板
 *
 * @author chenpeng
 */
@Slf4j
public abstract class AbstractSettlementTemplate {

    public static final BigDecimal ONE_PERCENT = new BigDecimal("0.01");


    public final void templateMethod(Context context) {
        // 校验参数
        check(context);

        // 获取抽佣
        getSnapshotRule(context);

        // 结算计算
        WalletInfo walletInfo = calculation(context);

        // 调用钱包
        addWallet(context, walletInfo);
    }

    /**
     * 校验结算参数
     *
     * @param context 上下文参数信息
     */
    public abstract void check(Context context);

    /**
     * 结算计算
     *
     * @param context 上下文参数信息
     * @return 钱包信息
     */
    public abstract WalletInfo calculation(Context context);

    /**
     * 获取司机抽佣比例
     *
     * @param context 上下文信息
     * @return 抽佣信息
     */
    private SnapshotRuleInfo getSnapshotRule(Context context) {
        log.info("已查询到司机:{},订单号:{}的抽佣", context.getOrderInfo().getDriverId(), context.getOrderInfo().getOrderId());
        SnapshotRuleInfo snapshotRuleInfo = new SnapshotRuleInfo();
        snapshotRuleInfo.setId(1L);
        snapshotRuleInfo.setDriverRatio(80);
        snapshotRuleInfo.setCarTeamRatio(10);
        snapshotRuleInfo.setPlatformRatio(10);
        context.setSnapshotRuleInfo(snapshotRuleInfo);
        return snapshotRuleInfo;
    }

    /**
     * 司机钱包加钱
     *
     * @param context    上下文参数信息
     * @param walletInfo 钱包信息
     */
    private void addWallet(Context context, WalletInfo walletInfo) {
        log.info("此{}:订单司机收入信息:{},抽佣信息:{}", context.getOrderInfo().getOrderId(), walletInfo, context.getSnapshotRuleInfo());
    }
}
