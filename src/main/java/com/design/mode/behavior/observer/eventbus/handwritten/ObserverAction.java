package com.design.mode.behavior.observer.eventbus.handwritten;

import com.google.common.base.Preconditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 观察者动作
 *
 * @author chenpeng
 */
public class ObserverAction {

    /**
     * 目标
     */
    private final Object target;
    /**
     * 方法
     */
    private final Method method;

    /**
     * 观察者动作
     *
     * @param target 目标
     * @param method 方法
     */
    public ObserverAction(Object target, Method method) {
        this.target = Preconditions.checkNotNull(target);
        this.method = method;
        // 不做权限检查
        this.method.setAccessible(true);
    }

    /**
     * 执行
     *
     * @param event 事件
     */
    public void execute(Object event) { // event是method方法的参数
        try {
            method.invoke(target, event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

