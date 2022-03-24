package com.design.pattern.behavior.observer.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * 数据观察2号
 *
 * @author chenpeng
 */
public class DataObserverTwo {

    /**
     * post() 不支持自动装箱功能,只能使用Integer,不能使用int,否则handlersByType的Class会是int而不是Intege
     * 而传入的int msg参数在post(int msg)的时候会被包装成Integer,导致无法匹配到
     *
     * @param msg 通知内容
     */
    @Subscribe
    public void func(Integer msg) {
        System.out.println("Integer msg " + msg);
    }
}
