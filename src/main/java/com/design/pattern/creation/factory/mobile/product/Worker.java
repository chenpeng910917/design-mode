package com.design.pattern.creation.factory.mobile.product;

import com.design.pattern.creation.factory.mobile.accessories.Camera;
import com.design.pattern.creation.factory.mobile.accessories.Cpu;
import com.design.pattern.creation.factory.mobile.accessories.Screen;
import com.design.pattern.creation.factory.mobile.factory.ComponentFactory;

/**
 * 工人
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class Worker {

    /**
     * 组装手机
     *
     * @param cpu    cpu
     * @param screen 屏幕
     * @param camera 摄像机
     */
    public void assembly(Cpu cpu, Screen screen, Camera camera) {
        System.out.println("开始组装>>");
        System.out.println("CPU:" + cpu.getSupplierType().getVersion() + "\n" + "SCREEN:" + screen.getSupplierType().getVersion() + "\n" + "CAMERA:" + camera.getSupplierType().getVersion());
        if (cpu.getSupplierType() != screen.getSupplierType() || cpu.getSupplierType() != camera.getSupplierType()) {
            throw new RuntimeException("装不上啊！");
        }
        System.out.println("组装完成<<");
    }

    /**
     * 零件组装
     *
     * @param factory 工厂实现
     */
    public void assembly(ComponentFactory factory) {
        assembly(factory.createCpu(), factory.createScreen(), factory.createCamera());
    }
}
