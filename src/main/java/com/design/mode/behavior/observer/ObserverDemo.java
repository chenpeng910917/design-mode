package com.design.mode.behavior.observer;

/**
 * 观察者模式例子
 *
 * @author chenpeng
 */
public class ObserverDemo {

    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers("通知明天放假");
    }

}
