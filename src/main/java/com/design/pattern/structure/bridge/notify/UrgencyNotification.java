package com.design.pattern.structure.bridge.notify;

import com.design.pattern.structure.bridge.send.MsgSender;

/**
 * 紧急通知
 *
 * @author chenpeng
 */
public class UrgencyNotification extends Notification {

    public UrgencyNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        //在此处可以实现业务紧急通知的具体业务逻辑

        msgSender.send(message);
    }
}
