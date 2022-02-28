package com.design.mode.structure.bridge.notify;

import com.design.mode.structure.bridge.send.MsgSender;

/**
 * 通知抽象类
 *
 * @author chenpeng
 */
public abstract class Notification {

    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    /**
     * 通知
     *
     * @param message 消息内容
     */
    public abstract void notify(String message);
}
