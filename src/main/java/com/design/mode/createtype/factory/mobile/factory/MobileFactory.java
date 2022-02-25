package com.design.mode.createtype.factory.mobile.factory;

import com.design.mode.createtype.factory.mobile.product.Mobile;

/**
 * 手机工厂接口
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public interface MobileFactory {

    /**
     * 创建手机
     *
     * @return 手机信息
     */
    Mobile createMobile();
}
