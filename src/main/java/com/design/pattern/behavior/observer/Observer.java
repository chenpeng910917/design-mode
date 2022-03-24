package com.design.pattern.behavior.observer;

/**
 * 观察员
 *
 * @author chenpeng
 */
public interface Observer {

    /**
     * 修改通知消息
     *
     * @param message 通知消息
     */
    void update(String message);
}
