package com.design.mode.behavior.visitor;

/**
 * 显示器
 *
 * @author chenpeng
 */
public class Monitor implements ComputerPart{

    @Override
    public void visit(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
