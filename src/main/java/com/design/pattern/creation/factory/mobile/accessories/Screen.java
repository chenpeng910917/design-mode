package com.design.pattern.creation.factory.mobile.accessories;

/**
 * 手机屏幕配件
 *
 * @author chenpeng
 */
public interface Screen {

    /**
     * 获取手机供应商类型
     * @return 手机供应商类型
     */
    SupplierTypeEnum getSupplierType();

    /**
     * 手机屏幕展示
     * @return 屏幕展示
     */
    String display();
}
