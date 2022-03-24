package com.design.pattern.creation.factory.mobile.factory;

import com.design.pattern.creation.factory.mobile.accessories.Camera;
import com.design.pattern.creation.factory.mobile.accessories.Cpu;
import com.design.pattern.creation.factory.mobile.accessories.Screen;

/**
 * 抽象工厂
 *
 * @author chenpeng
 */
public interface ComponentFactory {

    /**
     * 创建手机摄像头
     * @return 手机摄像头对下
     */
    Camera createCamera();

    /**
     * 创建手机cpu
     * @return 手机cpu对象
     */
    Cpu createCpu();

    /**
     * 创建手机屏幕
     * @return 手机屏幕对象
     */
    Screen createScreen();
}
