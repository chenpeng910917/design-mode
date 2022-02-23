package com.design.mode.factory.mobile.factory;

import com.design.mode.factory.mobile.accessories.SupplierTypeEnum;
import com.design.mode.factory.mobile.accessories.apple.AppleCamera;
import com.design.mode.factory.mobile.accessories.apple.AppleCpu;
import com.design.mode.factory.mobile.accessories.apple.AppleScreen;
import com.design.mode.factory.mobile.accessories.xiaomi.XiaoMiCamera;
import com.design.mode.factory.mobile.accessories.xiaomi.XiaoMiCpu;
import com.design.mode.factory.mobile.accessories.xiaomi.XiaoMiScreen;
import com.design.mode.factory.mobile.product.Iphone13;
import com.design.mode.factory.mobile.product.Mobile;
import com.design.mode.factory.mobile.product.XiaoMi12;

/**
 * 简单的工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class MobileSimpleFactory {

    public Mobile createMobile(SupplierTypeEnum supplierType) {
        if (supplierType == SupplierTypeEnum.APPLE) {
            return new Iphone13(SupplierTypeEnum.APPLE, new AppleCamera(), new AppleCpu(), new AppleScreen());
        } else if (supplierType == SupplierTypeEnum.XIAOMI) {
            return new XiaoMi12(SupplierTypeEnum.XIAOMI, new XiaoMiCamera(), new XiaoMiCpu(), new XiaoMiScreen());
        } else {
            throw new RuntimeException("不存在的供应商");
        }
    }
}
