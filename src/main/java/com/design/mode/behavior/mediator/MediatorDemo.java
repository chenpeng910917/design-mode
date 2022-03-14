package com.design.mode.behavior.mediator;

/**
 * 中介模式例子
 *
 * @author chenpeng
 */
public class MediatorDemo {

    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
