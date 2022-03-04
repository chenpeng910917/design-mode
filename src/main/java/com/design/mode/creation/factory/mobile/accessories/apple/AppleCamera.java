package com.design.mode.creation.factory.mobile.accessories.apple;

import com.design.mode.creation.factory.mobile.accessories.Camera;
import com.design.mode.creation.factory.mobile.accessories.SupplierTypeEnum;

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
