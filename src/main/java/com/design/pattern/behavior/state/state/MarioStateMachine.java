package com.design.pattern.behavior.state.state;

import com.design.pattern.behavior.state.State;

/**
 * 马里奥状态机 状态模式
 *
 * @author chenpeng
 */
public class MarioStateMachine {

    /**
     * 分数
     */
    private int score;
    /**
     * 当前状态
     */
    private Mario currentState;

    /**
     * 状态机 构造方法 默认为小马里奥
     */
    public MarioStateMachine() {
        this.score = 0;
        this.currentState = SmallMario.getInstance();
    }

    /**
     * 获得蘑菇事件
     */
    public void obtainMushRoom() {
        this.currentState.obtainMushRoom(this);
    }

    /**
     * 获得斗篷事件
     */
    public void obtainCape() {
        this.currentState.obtainCape(this);
    }

    /**
     * 获得火花事件
     */
    public void obtainFireFlower() {
        this.currentState.obtainFireFlower(this);
    }

    /**
     * 遇见怪物事件
     */
    public void meetMonster() {
        this.currentState.meetMonster(this);
    }

    /**
     * 获取分数
     *
     * @return 分数
     */
    public int getScore() {
        return this.score;
    }

    /**
     * 获取当前状态
     *
     * @return 状态
     */
    public State getCurrentState() {
        return this.currentState.getName();
    }

    /**
     * 设置分数
     *
     * @param score 分数
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * 设置当前状态
     * @param currentState 当前状态
     */
    public void setCurrentState(Mario currentState) {
        this.currentState = currentState;
    }
}
