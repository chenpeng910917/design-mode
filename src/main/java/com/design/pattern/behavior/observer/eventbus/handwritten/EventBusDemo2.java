package com.design.pattern.behavior.observer.eventbus.handwritten;

/**
 * @author chenpeng
 */
public class EventBusDemo2 {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        DataObserver1 dataObserver1 = new DataObserver1();
        eventBus.register(dataObserver1);

        Notice1 notice1 = new Notice1();
        notice1.setMsg("手写eventBus notice1通知消息");
        eventBus.post(notice1);
    }
}
