package com.design.pattern.behavior.state.state;

import com.design.pattern.behavior.state.State;

/**
 * 小马里奥
 *
 * @author chenpeng
 */
public class SmallMario implements Mario {
    /**
     * 单例小马里奥
     */
    private static final SmallMario INSTANCE = new SmallMario();

    /**
     * 私有构造方法
     */
    private SmallMario() {
    }

    /**
     * 获取小马里奥实例
     * @return 小马里奥实例
     */
    public static SmallMario getInstance() {
        return INSTANCE;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(SuperMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(CapeMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        stateMachine.setCurrentState(FireMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        // do nothing...
    }
}
