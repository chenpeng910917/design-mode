package com.design.pattern.structure.bridge.send;

import lombok.extern.slf4j.Slf4j;

/**
 * 钉钉消息发送
 *
 * @author chenpeng
 */
@Slf4j
public class DingDingMsgSender implements MsgSender {

    @Override
    public void send(String message) {
        log.info("钉钉短信发送消息:{}", message);
    }
}
