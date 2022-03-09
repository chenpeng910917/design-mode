package com.design.mode.behavior.visitor;

/**
 * 访问者模式例子
 *
 * @author chenpeng
 */
public class VisitorDemo {
    public static void main(String[] args) {
        // 创建键盘
        ComputerPart keyBoard = new KeyBoard();
        keyBoard.visit(new ComputerPartVisitorImpl());
    }
}
