package com.design.pattern.behavior.observer.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * 数据观察1号
 *
 * @author chenpeng
 */
public class DataObserver2 {

    /**
     * 只有通过@Subscribe注解的方法才会被注册到EventBus
     * 而且方法有且只有1个参数
     *
     * @param msg 通知内容
     */
    @Subscribe
    public void func(Notice2 msg) {
        System.out.println("Notice2 msg " + msg.getMsg());
    }
}
