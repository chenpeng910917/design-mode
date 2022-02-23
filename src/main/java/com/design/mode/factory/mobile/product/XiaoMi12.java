package com.design.mode.factory.mobile.product;

import com.design.mode.factory.mobile.accessories.Camera;
import com.design.mode.factory.mobile.accessories.Cpu;
import com.design.mode.factory.mobile.accessories.Screen;
import com.design.mode.factory.mobile.accessories.SupplierTypeEnum;

/**
 * 小米12 手机
 *
 * @author chenpeng
 * @date 2022/2/22
 */
public class XiaoMi12 implements Mobile {

    /**
     * 手机供应商
     */
    private SupplierTypeEnum supplierType;
    /**
     * 手机摄像头配件
     */
    private Camera camera;
    /**
     * 手机cpu配件
     */
    private Cpu cpu;
    /**
     * 手机屏幕配件
     */
    private Screen screen;

    /**
     * 构造方法
     *
     * @param supplierType 手机供应商
     * @param camera       手机摄像头配件
     * @param cpu          手机cpu配件
     * @param screen       手机屏幕配件
     */
    public XiaoMi12(SupplierTypeEnum supplierType, Camera camera, Cpu cpu, Screen screen) {
        this.supplierType = supplierType;
        this.camera = camera;
        this.cpu = cpu;
        this.screen = screen;
    }

    @Override
    public String getBrand() {
        return supplierType.toString();
    }

    @Override
    public void call() {
        System.out.println("接通中....");
    }
}
