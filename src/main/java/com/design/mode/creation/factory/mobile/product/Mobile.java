package com.design.mode.creation.factory.mobile.product;

/**
 * 手机
 *
 * @author chenpeng
 * @date 2022/2/22
 */
public interface Mobile {

    /**
     * 手机品牌
     *
     * @return 手机品牌
     */
    String getBrand();

    /**
     * 打电话
     */
    void call();
}
