package com.design.pattern.behavior.visitor;

/**
 * 键盘
 *
 * @author chenpeng
 */
public class KeyBoard implements ComputerPart {
    @Override
    public void visit(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
