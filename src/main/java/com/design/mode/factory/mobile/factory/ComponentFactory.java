package com.design.mode.factory.mobile.factory;

import com.design.mode.factory.mobile.accessories.Camera;
import com.design.mode.factory.mobile.accessories.Cpu;
import com.design.mode.factory.mobile.accessories.Screen;

/**
 * 抽象工厂
 *
 * @author chenpeng
 */
public interface ComponentFactory {

    Camera createCamera();

    Cpu createCpu();

    Screen createScreen();
}
