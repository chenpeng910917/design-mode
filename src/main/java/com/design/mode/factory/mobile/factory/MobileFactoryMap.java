package com.design.mode.factory.mobile.factory;

import com.design.mode.factory.mobile.accessories.SupplierTypeEnum;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 手机工厂的工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class MobileFactoryMap {

    private static final Map<String, MobileFactory> CACHE_MOBILE = Maps.newHashMap();

    static {
        CACHE_MOBILE.put(SupplierTypeEnum.APPLE.getVersion(), new Iphone13MobileFactory());
        CACHE_MOBILE.put(SupplierTypeEnum.XIAOMI.getVersion(), new XiaoMi12MobileFactory());
    }

    public static MobileFactory createMobile(SupplierTypeEnum supplierType) {
        return CACHE_MOBILE.get(supplierType.getVersion());
    }
}
