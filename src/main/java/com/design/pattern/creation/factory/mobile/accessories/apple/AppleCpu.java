package com.design.pattern.creation.factory.mobile.accessories.apple;

import com.design.pattern.creation.factory.mobile.accessories.Cpu;
import com.design.pattern.creation.factory.mobile.accessories.SupplierTypeEnum;

/**
 * 苹果cpu实现
 *
 * @author chenpeng
 * @date 2022/2/22
 */
public class AppleCpu implements Cpu {

    @Override
    public SupplierTypeEnum getSupplierType() {
        return SupplierTypeEnum.APPLE;
    }

    @Override
    public String operate() {
        return "apple cpu operating";
    }
}
