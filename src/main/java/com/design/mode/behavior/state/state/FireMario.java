package com.design.mode.behavior.state.state;

import com.design.mode.behavior.state.State;

/**
 * 火花马里奥
 * @author chenpeng
 */
public class FireMario implements Mario{
    /**
     * 单例火花马里奥
     */
    private final static FireMario INSTANCE = new FireMario();

    /**
     * 私有构造
     */
    private FireMario() {

    }

    /**
     * 获取单例火花马里奥
     * @return 火花马里奥
     */
    public static FireMario getInstance() {
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
