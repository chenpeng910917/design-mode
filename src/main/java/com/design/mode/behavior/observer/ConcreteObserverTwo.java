package com.design.mode.behavior.observer;

/**
 * 具体观察者二号
 *
 * @author chenpeng
 */
public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(String message) {
        // 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverTwo is notified." + message);
    }
}
