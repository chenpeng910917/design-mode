package com.design.pattern.structure.bridge.notify;

import com.design.pattern.structure.bridge.send.MsgSender;

/**
 * 服务通知
 *
 * @author chenpeng
 */
public class ServerNotification extends Notification {

    public ServerNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        //在此处可以实现业务服务通知的具体业务逻辑

        msgSender.send(message);
    }
}
