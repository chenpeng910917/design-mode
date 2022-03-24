package com.design.pattern.behavior.state;

/**
 * 事件
 *
 * @author chenpeng
 */
public enum Event {
    /**
     * 有蘑菇
     */
    GOT_MUSHROOM(0),
    /**
     * 有斗篷
     */
    GOT_CAPE(1),
    /**
     * 有火花
     */
    GOT_FIRE(2),
    /**
     * 怪物
     */
    MET_MONSTER(3);

    private int value;

    Event(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
