package com.design.mode.structure.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付类型
 *
 * @author chenpeng
 */
@Getter
@AllArgsConstructor
public enum PayTypeEnum {
    /**
     * 支付宝支付类型
     */
    ALI(1),
    /**
     * 微信支付类型
     */
    WECHAT(2),
    ;

    /**
     * 支付类型
     */
    private final Integer type;
}
