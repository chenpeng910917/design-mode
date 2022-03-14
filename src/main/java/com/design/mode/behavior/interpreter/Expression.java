package com.design.mode.behavior.interpreter;

/**
 * 表达式
 *
 * @author chenpeng
 */
public interface Expression {

    /**
     * 解释
     *
     * @param context 上下文
     * @return 真假
     */
    boolean interpret(String context);
}