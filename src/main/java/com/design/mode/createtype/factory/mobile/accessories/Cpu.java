package com.design.mode.createtype.factory.mobile.accessories;

/**
 * 手机CPU配件
 *
 * @author chenpeng
 */
public interface Cpu {

    /**
     * 获取手机供应商类型
     * @return 手机供应商类型
     */
    SupplierTypeEnum getSupplierType();

    /**
     * cpu操作
     * @return cpu操作
     */
    String operate();
}
