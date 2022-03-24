package com.design.pattern.behavior.observer;

/**
 * 具体观察者一号
 *
 * @author chenpeng
 */
public class ConcreteObserverOne implements Observer {
    @Override
    public void update(String message) {
        // 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverOne is notified." + message);
    }
}
