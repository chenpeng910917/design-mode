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
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 简单的工厂2
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class MobileSimpleFactory2 {
    private static final Map<String, Mobile> cacheMobile = Maps.newHashMap();

    static {
        cacheMobile.put(SupplierTypeEnum.APPLE.getVersion(), new Iphone13(SupplierTypeEnum.APPLE, new AppleCamera(), new AppleCpu(), new AppleScreen()));
        cacheMobile.put(SupplierTypeEnum.XIAOMI.getVersion(), new XiaoMi12(SupplierTypeEnum.XIAOMI, new XiaoMiCamera(), new XiaoMiCpu(), new XiaoMiScreen()));
    }

    public Mobile createMobile(SupplierTypeEnum supplierType) {
        return cacheMobile.get(supplierType.getVersion());
    }
}
