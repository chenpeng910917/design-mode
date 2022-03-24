package com.design.pattern.behavior.observer;

/**
 * 主题
 *
 * @author chenpeng
 */
public interface Subject {

    /**
     * 注册观察员
     *
     * @param observer 观察员
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察员
     *
     * @param observer 观察员
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察员
     *
     * @param message 通知消息
     */
    void notifyObservers(String message);
}
