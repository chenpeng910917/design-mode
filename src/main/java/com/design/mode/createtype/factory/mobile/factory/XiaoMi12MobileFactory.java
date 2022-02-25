package com.design.mode.createtype.factory.mobile.factory;

import com.design.mode.createtype.factory.mobile.accessories.SupplierTypeEnum;
import com.design.mode.createtype.factory.mobile.accessories.xiaomi.XiaoMiCamera;
import com.design.mode.createtype.factory.mobile.accessories.xiaomi.XiaoMiCpu;
import com.design.mode.createtype.factory.mobile.accessories.xiaomi.XiaoMiScreen;
import com.design.mode.createtype.factory.mobile.product.Mobile;
import com.design.mode.createtype.factory.mobile.product.XiaoMi12;

/**
 * 小米手机工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class XiaoMi12MobileFactory implements MobileFactory {
    @Override
    public Mobile createMobile() {
        return new XiaoMi12(SupplierTypeEnum.XIAOMI, new XiaoMiCamera(), new XiaoMiCpu(), new XiaoMiScreen());
    }
}
