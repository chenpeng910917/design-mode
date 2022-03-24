package com.design.pattern.creation.factory.mobile.accessories.xiaomi;

import com.design.pattern.creation.factory.mobile.accessories.Screen;
import com.design.pattern.creation.factory.mobile.accessories.SupplierTypeEnum;

/**
 * 小米屏幕实现
 *
 * @author chenpeng
 * @date 2022/2/22
 */
public class XiaoMiScreen implements Screen {

    @Override
    public SupplierTypeEnum getSupplierType() {
        return SupplierTypeEnum.XIAOMI;
    }

    @Override
    public String display() {
        return "apple screen display";
    }
}
