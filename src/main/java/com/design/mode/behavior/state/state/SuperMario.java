package com.design.mode.behavior.state.state;

import com.design.mode.behavior.state.State;

/**
 * 超级马里奥
 *
 * @author chenpeng
 */
public class SuperMario implements Mario {

    /**
     * 单例超级马里奥
     */
    private static final SuperMario INSTANCE = new SuperMario();

    /**
     * 私有构造
     */
    private SuperMario() {
    }

    /**
     * 获取单例超级马里奥
     *
     * @return 超级马里奥实例
     */
    public static SuperMario getInstance() {
        return INSTANCE;
    }

    @Override
    public State getName() {
        return State.SUPER;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {

    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {

    }
}
