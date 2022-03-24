package com.design.pattern.structure.decorator;

/**
 * 形状装饰器
 *
 * @author chenpeng
 */
public abstract class ShapeDecorator {

    protected Shape decoratorShape;

    public ShapeDecorator(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    public void draw() {
        decoratorShape.draw();
    }
}
