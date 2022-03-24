package com.design.pattern.behavior.visitor;

/**
 * 电脑零件接口
 *
 * @author chenpeng
 */
public interface ComputerPart {

    /**
     * 访问
     *
     * @param computerPartVisitor 电脑访客接口
     */
    void visit(ComputerPartVisitor computerPartVisitor);
}
