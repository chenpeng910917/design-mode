package com.design.pattern.creation.factory.mobile.accessories.apple;

import com.design.pattern.creation.factory.mobile.accessories.Screen;
import com.design.pattern.creation.factory.mobile.accessories.SupplierTypeEnum;

/**
 * 苹果屏幕实现
 *
 * @author chenpeng
 * @date 2022/2/22
 */
public class AppleScreen implements Screen {

    @Override
    public SupplierTypeEnum getSupplierType() {
        return SupplierTypeEnum.APPLE;
    }

    @Override
    public String display() {
        return "apple screen display";
    }
}
