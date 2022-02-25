package com.design.mode.createtype.factory.mobile.accessories.apple;

import com.design.mode.createtype.factory.mobile.accessories.Camera;
import com.design.mode.createtype.factory.mobile.accessories.SupplierTypeEnum;

/**
 * 苹果摄像头实现
 *
 * @author chenpeng
 * @date 2022/2/22
 */
public class AppleCamera implements Camera {

    @Override
    public SupplierTypeEnum getSupplierType() {
        return SupplierTypeEnum.APPLE;
    }

    @Override
    public String photograph() {
        return "apple camera photograph";
    }
}
