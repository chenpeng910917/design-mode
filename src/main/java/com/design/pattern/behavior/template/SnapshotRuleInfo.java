package com.design.pattern.behavior.template;

import lombok.Data;

/**
 * 抽佣规则快照信息
 *
 * @author chenpeng
 */
@Data
public class SnapshotRuleInfo {

    /**
     * 抽佣快照id
     */
    private Long id;

    /**
     * 司机抽佣比例
     */
    private Integer driverRatio;

    /**
     * 平台抽佣比例
     */
    private Integer platformRatio;

    /**
     * 车队抽佣比例
     */
    private Integer carTeamRatio;

    // 省略其他信息
}
