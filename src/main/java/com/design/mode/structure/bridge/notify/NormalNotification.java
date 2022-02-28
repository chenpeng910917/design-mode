package com.design.mode.structure.bridge.notify;

import com.design.mode.structure.bridge.send.MsgSender;

/**
 * 正常通知
 *
 * @author chenpeng
 */
public class NormalNotification extends Notification {

    public NormalNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        //在此处可以实现业务正常通知的具体业务逻辑

        msgSender.send(message);
    }
}
