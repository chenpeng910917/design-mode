package com.design.pattern.behavior.state.state;

import com.design.pattern.behavior.state.State;

/**
 * 马里奥所有状态接口
 *
 * @author chenpeng
 */
public interface Mario {

    /**
     * 获取状态
     *
     * @return 状态
     */
    State getName();

    /**
     * 获得蘑菇事件
     * @param stateMachine 马里奥状态机
     */
    void obtainMushRoom(MarioStateMachine stateMachine);

    /**
     * 获得斗篷事件
     * @param stateMachine 马里奥状态机
     */
    void obtainCape(MarioStateMachine stateMachine);

    /**
     * 获得火花事件
     * @param stateMachine 马里奥状态机
     */
    void obtainFireFlower(MarioStateMachine stateMachine);

    /**
     * 遇见怪物事件
     * @param stateMachine 马里奥状态机
     */
    void meetMonster(MarioStateMachine stateMachine);
}
