package com.design.mode.factory.mobile.accessories;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 手机供应商
 *
 * @author chenpeng
 */
@Getter
@AllArgsConstructor
public enum SupplierTypeEnum {

    /**
     * 苹果
     */
    APPLE("APPLE/1.0"),
    /**
     * 小米
     */
    XIAOMI("XIAOMI/1.0");

    /**
     * 版本号
     */
    private String version;
}
