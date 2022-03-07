package com.design.mode.behavior.observer.eventbus.handwritten;

import java.util.concurrent.Executor;

/**
 * 异步事件总线
 *
 * @author chenpeng
 */
public class AsyncEventBus extends EventBus {

    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
