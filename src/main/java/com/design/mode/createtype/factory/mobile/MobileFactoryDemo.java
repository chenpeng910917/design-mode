package com.design.mode.createtype.factory.mobile;

import com.design.mode.createtype.factory.mobile.accessories.SupplierTypeEnum;
import com.design.mode.createtype.factory.mobile.accessories.apple.AppleCamera;
import com.design.mode.createtype.factory.mobile.accessories.apple.AppleCpu;
import com.design.mode.createtype.factory.mobile.accessories.apple.AppleScreen;
import com.design.mode.createtype.factory.mobile.accessories.xiaomi.XiaoMiCamera;
import com.design.mode.createtype.factory.mobile.accessories.xiaomi.XiaoMiCpu;
import com.design.mode.createtype.factory.mobile.accessories.xiaomi.XiaoMiScreen;
import com.design.mode.createtype.factory.mobile.factory.AppleComponentFactory;
import com.design.mode.createtype.factory.mobile.factory.ComponentFactory;
import com.design.mode.createtype.factory.mobile.factory.MobileFactory;
import com.design.mode.createtype.factory.mobile.factory.MobileFactoryMap;
import com.design.mode.createtype.factory.mobile.factory.MobileSimpleFactory;
import com.design.mode.createtype.factory.mobile.factory.MobileSimpleFactory2;
import com.design.mode.createtype.factory.mobile.factory.XiaoMiComponentFactory;
import com.design.mode.createtype.factory.mobile.product.Iphone13;
import com.design.mode.createtype.factory.mobile.product.Mobile;
import com.design.mode.createtype.factory.mobile.product.Worker;
import com.design.mode.createtype.factory.mobile.product.XiaoMi12;
import com.design.mode.createtype.factory.mobile.role.User;

/**
 * 手机工厂模式例子
 *
 * @author chenpeng
 * @date 2022/2/21
 */
public class MobileFactoryDemo {

    public static void main(String[] args) {
        // 不使用工厂模式
        ordinary();

        // 简单工厂
        simple();

        // 简单工厂 第二种实现
        simple2();

        // 工厂
        factory();

        // 抽象工厂
        absFactory();
    }

    /**
     * 不使用工厂模式
     * 缺点：需要自己创建大量对象
     */
    private static void ordinary() {
        User user = new User();
        Mobile mobile = new Iphone13(SupplierTypeEnum.APPLE, new AppleCamera(), new AppleCpu(), new AppleScreen());
        user.doCall(mobile);
        mobile = new XiaoMi12(SupplierTypeEnum.XIAOMI, new XiaoMiCamera(), new XiaoMiCpu(), new XiaoMiScreen());
        user.doCall(mobile);
    }

    /**
     * 简单工厂
     * 把创建对象交给单独类处理
     * 缺点：不符合开闭原则；创建对象if判断逻辑多(如果没几个if尽量使用简单工厂)
     * 优点：可读性好
     */
    private static void simple() {
        User user = new User();
        MobileSimpleFactory mobileSimpleFactory = new MobileSimpleFactory();
        Mobile mobile = mobileSimpleFactory.createMobile(SupplierTypeEnum.APPLE);
        user.doCall(mobile);
        mobile = mobileSimpleFactory.createMobile(SupplierTypeEnum.XIAOMI);
        user.doCall(mobile);
    }

    /**
     * 简单工厂2
     * 使用Map方式去掉多if 类似单例+工厂
     * 优点：去掉了if判断
     * 缺点：不符合开闭原则
     */
    private static void simple2() {
        User user = new User();
        MobileSimpleFactory2 mobileSimpleFactory2 = new MobileSimpleFactory2();
        user.doCall(mobileSimpleFactory2.createMobile(SupplierTypeEnum.APPLE));
        user.doCall(mobileSimpleFactory2.createMobile(SupplierTypeEnum.XIAOMI));
    }

    /**
     * 工厂方法
     * 利用java多态实现
     * 缺点：可读性不好，如果商品过多类就会变多
     * 优点：去掉了if判断
     */
    private static void factory() {
        User user = new User();
        // 工厂的工厂 解决if问题
        MobileFactory iphone13MobileFactory = MobileFactoryMap.createMobile(SupplierTypeEnum.APPLE);
        user.doCall(iphone13MobileFactory.createMobile());
        MobileFactory xiaoMi12MobileFactory = MobileFactoryMap.createMobile(SupplierTypeEnum.APPLE);
        user.doCall(xiaoMi12MobileFactory.createMobile());
    }

    /**
     * 抽象工厂
     */
    private static void absFactory() {
        Worker worker = new Worker();
        worker.assembly(new AppleCpu(), new AppleScreen(), new AppleCamera());
        ComponentFactory componentFactory = new AppleComponentFactory();
        worker.assembly(componentFactory);
        componentFactory = new XiaoMiComponentFactory();
        worker.assembly(componentFactory);
    }
}
