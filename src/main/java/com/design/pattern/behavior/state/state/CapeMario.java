package com.design.pattern.behavior.state.state;

import com.design.pattern.behavior.state.State;

/**
 * 斗篷马里奥
 *
 * @author chenpeng
 */
public class CapeMario implements Mario {
    /**
     * 单例斗篷马里奥
     */
    private final static CapeMario INSTANCE = new CapeMario();

    /**
     * 私有构造
     */
    private CapeMario() {

    }

    /**
     * 获取单例斗篷马里奥
     *
     * @return 斗篷马里奥
     */
    public static CapeMario getInstance() {
        return INSTANCE;
    }

    @Override
    public State getName() {
        return null;
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
