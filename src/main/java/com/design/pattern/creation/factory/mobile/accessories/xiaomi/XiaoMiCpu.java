package com.design.pattern.creation.factory.mobile.accessories.xiaomi;

import com.design.pattern.creation.factory.mobile.accessories.Cpu;
import com.design.pattern.creation.factory.mobile.accessories.SupplierTypeEnum;

/**
 * 小米cpu实现
 *
 * @author chenpeng
 * @date 2022/2/22
 */
public class XiaoMiCpu implements Cpu {

    @Override
    public SupplierTypeEnum getSupplierType() {
        return SupplierTypeEnum.XIAOMI;
    }

    @Override
    public String operate() {
        return "apple cpu operating";
    }
}
