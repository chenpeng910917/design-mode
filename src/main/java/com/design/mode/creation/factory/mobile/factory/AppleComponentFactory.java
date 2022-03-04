package com.design.mode.creation.factory.mobile.factory;

import com.design.mode.creation.factory.mobile.accessories.Camera;
import com.design.mode.creation.factory.mobile.accessories.Cpu;
import com.design.mode.creation.factory.mobile.accessories.Screen;
import com.design.mode.creation.factory.mobile.accessories.apple.AppleCamera;
import com.design.mode.creation.factory.mobile.accessories.apple.AppleCpu;
import com.design.mode.creation.factory.mobile.accessories.apple.AppleScreen;

/**
 * 苹果手机抽象工厂
 *
 * @author chenpeng
 */
public class AppleComponentFactory implements ComponentFactory {
    @Override
    public Camera createCamera() {
        return new AppleCamera();
    }

    @Override
    public Cpu createCpu() {
        return new AppleCpu();
    }

    @Override
    public Screen createScreen() {
        return new AppleScreen();
    }
}
