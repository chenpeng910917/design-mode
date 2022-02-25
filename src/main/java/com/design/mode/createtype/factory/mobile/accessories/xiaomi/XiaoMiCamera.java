package com.design.mode.createtype.factory.mobile.accessories.xiaomi;

import com.design.mode.createtype.factory.mobile.accessories.Camera;
import com.design.mode.createtype.factory.mobile.accessories.SupplierTypeEnum;

/**
 * 小米摄像头实现
 *
 * @author chenpeng
 * @date 2022/2/22
 */
public class XiaoMiCamera implements Camera {

    @Override
    public SupplierTypeEnum getSupplierType() {
        return SupplierTypeEnum.XIAOMI;
    }

    @Override
    public String photograph() {
        return "apple camera photograph";
    }
}
