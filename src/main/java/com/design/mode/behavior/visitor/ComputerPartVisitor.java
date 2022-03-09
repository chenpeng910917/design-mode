package com.design.mode.behavior.visitor;


/**
 * 电脑访客接口
 *
 * @author chenpeng
 */
public interface ComputerPartVisitor {

    /**
     * 访问键盘
     *
     * @param keyBoard 键盘
     */
    void visit(KeyBoard keyBoard);

    /**
     * 访问鼠标
     * @param mouse 鼠标
     */
    void visit(Mouse mouse);

    /**
     * 访问显示器
     * @param monitor 显示器
     */
    void visit(Monitor monitor);
}
