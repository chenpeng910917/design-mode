package com.design.mode.behavior.observer.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

import java.util.concurrent.Executors;

/**
 * 谷歌事件总线例子
 *
 * @author chenpeng
 */
public class EventBusDemo {

    public static void main(String[] args) {
        // 同步阻塞模式
        EventBus eventBus = new EventBus();
        // 异步阻塞模式
        EventBus asyncEventBus = new AsyncEventBus(Executors.newFixedThreadPool(8));

        DataObserverOne dataObserverOne = new DataObserverOne();
        DataObserverTwo dataObserverTwo = new DataObserverTwo();
        DataObserver1 dataObserver1 = new DataObserver1();
        DataObserver2 dataObserver2 = new DataObserver2();
        // 注册
        eventBus.register(dataObserverOne);
        eventBus.register(dataObserverTwo);
        eventBus.register(dataObserver1);
        eventBus.register(dataObserver2);

        System.out.println("============   start  ====================");

        // 只有注册的参数类型为String的方法会被调用
        eventBus.post("post string method");
        eventBus.post(123);

        Notice1 notice1 = new Notice1();
        notice1.setMsg("notice1通知消息");
        eventBus.post(notice1);
        Notice2 notice2 = new Notice2();
        notice2.setMsg("notice2通知消息");
        eventBus.post(notice2);

        System.out.println("============ after unregister ============");
        // 注销observer2
        eventBus.unregister(dataObserverTwo);
        eventBus.post("post string method");
        eventBus.post(123);

        System.out.println("============    end           =============");
    }
}
