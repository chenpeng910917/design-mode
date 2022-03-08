package com.design.mode.behavior.state;

/**
 * 马里奥状态机 查表法
 *
 * @author chenpeng
 */
public class MarioStateMachineTable {
    /**
     * 分数
     */
    private int score;
    /**
     * 当前状态
     */
    private State currentState;
    /**
     * 转换表
     */
    private static final State[][] transitionTable = {
            {State.SUPER, State.CAPE, State.FIRE, State.SMALL},
            {State.SUPER, State.CAPE, State.FIRE, State.SMALL},
            {State.CAPE, State.CAPE, State.CAPE, State.SMALL},
            {State.FIRE, State.FIRE, State.FIRE, State.SMALL}
    };
    /**
     * 动作表
     */
    private static final int[][] actionTable = {
            {+100, +200, +300, +0},
            {+0, +200, +300, -100},
            {+0, +0, +0, -200},
            {+0, +0, +0, -300}
    };

    /**
     * 马里奥状态机 构造方法
     */
    public MarioStateMachineTable() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    /**
     * 获得蘑菇
     */
    public void obtainMushRoom() {
        executeEvent(Event.GOT_MUSHROOM);
    }

    /**
     * 获得斗篷
     */
    public void obtainCape() {
        executeEvent(Event.GOT_CAPE);
    }

    /**
     * 获得火花
     */
    public void obtainFireFlower() {
        executeEvent(Event.GOT_FIRE);
    }

    /**
     * 遇见怪物
     */
    public void meetMonster() {
        executeEvent(Event.MET_MONSTER);
    }

    /**
     * 执行事件
     *
     * @param event 事件
     */
    private void executeEvent(Event event) {
        int stateValue = currentState.getValue();
        int eventValue = event.getValue();
        this.currentState = transitionTable[stateValue][eventValue];
        this.score = actionTable[stateValue][eventValue];
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
     * 获得当前状态
     *
     * @return 状态
     */
    public State getCurrentState() {
        return this.currentState;
    }
}
