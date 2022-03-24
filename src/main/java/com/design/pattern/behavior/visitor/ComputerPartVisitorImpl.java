package com.design.pattern.behavior.visitor;

/**
 * 电脑访客
 *
 * @author chenpeng
 */
public class ComputerPartVisitorImpl implements ComputerPartVisitor {
    @Override
    public void visit(KeyBoard keyBoard) {
        System.out.println("展示keyBoard");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("展示mouse");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("展示monitor");
    }
}
