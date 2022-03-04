package com.design.mode.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体主题
 *
 * @author chenpeng
 */
public class ConcreteSubject implements Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
