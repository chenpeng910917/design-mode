package com.design.mode.factory.mobile.factory;

import com.design.mode.factory.mobile.accessories.SupplierTypeEnum;
import com.design.mode.factory.mobile.accessories.apple.AppleCamera;
import com.design.mode.factory.mobile.accessories.apple.AppleCpu;
import com.design.mode.factory.mobile.accessories.apple.AppleScreen;
import com.design.mode.factory.mobile.product.Iphone13;
import com.design.mode.factory.mobile.product.Mobile;

/**
 * 苹果手机工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class Iphone13MobileFactory implements MobileFactory {
    @Override
    public Mobile createMobile() {
        return new Iphone13(SupplierTypeEnum.APPLE, new AppleCamera(), new AppleCpu(), new AppleScreen());
    }
}
