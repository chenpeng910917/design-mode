package com.design.mode.behavior.interpreter;

import lombok.extern.slf4j.Slf4j;

/**
 * 解释器模式例子
 *
 * @author chenpeng
 */
@Slf4j
public class InterpreterDemo {

    /**
     * 规则 ： Robert 和 John 是男性
     *
     * @return 或表达式
     */
    public static Expression getMaleExpression() {
        // 罗伯特
        Expression robert = new TerminalExpression("robert");
        // 约翰
        Expression john = new TerminalExpression("john");
        return new OrExpression(robert, john);
    }

    /**
     * 规则 ： Julie 是一个已婚女性
     *
     * @return 与表达式
     */
    public static Expression getMarriedWomanExpression() {
        Expression julie = new TerminalExpression("julie");
        Expression married = new TerminalExpression("married");
        return new AndExpression(julie, married);
    }

    public static void main(String[] args) {
        // 男性规则
        Expression maleExpression = getMaleExpression();
        // 已婚女性规则
        Expression marriedWomanExpression = getMarriedWomanExpression();

        // john 是一名男性
        log.info("john is male？{}", maleExpression.interpret("john"));

        // julie是一名已婚女性
        log.info("julie is a married women? {}" ,marriedWomanExpression.interpret("married julie"));
    }
}
