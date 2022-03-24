package com.design.pattern.behavior.visitor;

/**
 * 鼠标
 *
 * @author chenpeng
 */
public class Mouse implements ComputerPart{
    @Override
    public void visit(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
