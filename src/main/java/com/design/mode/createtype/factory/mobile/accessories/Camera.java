package com.design.mode.createtype.factory.mobile.accessories;

/**
 * 手机摄像头配件
 *
 * @author chenpeng
 */
public interface Camera {

    /**
     * 获取手机供应商类型
     * @return 手机供应商类型
     */
    SupplierTypeEnum getSupplierType();

    /**
     * 拍照
     * @return 拍照
     */
    String photograph();

}
