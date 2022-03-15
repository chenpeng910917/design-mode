package com.design.mode.structure.bridge;

import com.design.mode.structure.bridge.notify.NormalNotification;
import com.design.mode.structure.bridge.notify.ServerNotification;
import com.design.mode.structure.bridge.notify.UrgencyNotification;
import com.design.mode.structure.bridge.send.DingDingMsgSender;
import com.design.mode.structure.bridge.send.TelephoneMsgSender;

/**
 * 桥接模式例子
 *
 * @author chenpeng
 */
public class BridgeDemo {
    public static void main(String[] args) {

        // 钉钉服务通知发送消息
        ServerNotification serverNotification = new ServerNotification(new DingDingMsgSender());
        serverNotification.notify("钉钉服务通知发送消息");

        // 钉钉紧急通知发送消息
        UrgencyNotification urgencyNotification = new UrgencyNotification(new DingDingMsgSender());
        urgencyNotification.notify("钉钉紧急通知发送消息");

        // 手机短信正常通知发送消息
        NormalNotification normalNotification = new NormalNotification(new TelephoneMsgSender());
        normalNotification.notify("手机短信正常通知发送消息");
    }
}
