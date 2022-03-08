package com.design.mode.behavior.state;

/**
 * 马里奥状态机 分支逻辑法
 *
 * @author chenpeng
 */
public class MarioStateMachineBranch {
    /**
     * 分数
     */
    private int score;
    /**
     * 当前状态
     */
    private State currentState;

    /**
     * 马里奥状态机 构造方法
     */
    public MarioStateMachineBranch() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    /**
     * 获得蘑菇
     */
    public void obtainMushRoom() {
        if (currentState.equals(State.SMALL)) {
            this.currentState = State.SUPER;
            this.score += 100;
        }
    }

    /**
     * 获得斗篷
     */
    public void obtainCape() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            this.currentState = State.CAPE;
            this.score += 200;
        }
    }

    /**
     * 获得火花
     */
    public void obtainFireFlower() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            this.currentState = State.FIRE;
            this.score += 300;
        }
    }

    /**
     * 遇见怪物
     */
    public void meetMonster() {
        if (currentState.equals(State.SUPER)) {
            this.currentState = State.SMALL;
            this.score -= 100;
            return;
        }
        if (currentState.equals(State.CAPE)) {
            this.currentState = State.SMALL;
            this.score -= 200;
            return;
        }
        if (currentState.equals(State.FIRE)) {
            this.currentState = State.SMALL;
            this.score -= 300;
            return;
        }
    }

    /**
     * 获得分数
     *
     * @return 分数
     */
    public int getScore() {
        return this.score;
    }

    /**
     * 当前状态
     *
     * @return 状态
     */
    public State getCurrentState() {
        return this.currentState;
    }
}
