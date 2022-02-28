package com.design.mode.structure.decorator;

/**
 * 装饰器模式例子
 *
 * @author chenpeng
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        // 圆形
        Shape circle = new Circle();
        // 红色边框 的圆形
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        // 红色边框 的长方形
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());

        // 画形状
        circle.draw();

        System.out.println("带红色边框的圆形");
        redCircle.draw();

        System.out.println("带红色边框的长方形");
        redRectangle.draw();
    }
}
