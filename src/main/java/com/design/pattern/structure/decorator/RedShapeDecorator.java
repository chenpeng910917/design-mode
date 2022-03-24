package com.design.pattern.structure.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 红色形状边框
 *
 * @author chenpeng
 */
@Slf4j
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratorShape) {
        super(decoratorShape);
    }

    @Override
    public void draw() {
        decoratorShape.draw();
        setRedBorder(decoratorShape);
    }

    private void setRedBorder(Shape decoratorShape) {
        log.info("画红色边框");
    }
}
