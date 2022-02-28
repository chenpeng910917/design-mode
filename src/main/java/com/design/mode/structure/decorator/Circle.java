package com.design.mode.structure.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 圆形
 *
 * @author chenpeng
 */
@Slf4j
public class Circle implements Shape {
    @Override
    public void draw() {
        log.info("画形状：圆形");
    }
}
