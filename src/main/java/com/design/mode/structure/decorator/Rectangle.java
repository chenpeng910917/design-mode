package com.design.mode.structure.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 长方形
 *
 * @author chenpeng
 */
@Slf4j
public class Rectangle implements Shape {
    @Override
    public void draw() {
        log.info("画形状：长方形");
    }
}
