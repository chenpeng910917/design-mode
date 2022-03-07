package com.design.mode.behavior.observer.eventbus.handwritten;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * 事件总线
 *
 * @author chenpeng
 */
public class EventBus {
    /**
     * 执行者
     */
    private Executor executor;
    /**
     * 注册表
     */
    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    protected EventBus(Executor executor) {
        this.executor = executor;
    }

    /**
     * 注册
     * @param object 观察者
     */
    public void register(Object object) {
        registry.register(object);
    }

    /**
     * 通知
     * @param event 事件
     */
    public void post(Object event) {
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (ObserverAction observerAction : observerActions) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    observerAction.execute(event);
                }
            });
        }
    }
}
