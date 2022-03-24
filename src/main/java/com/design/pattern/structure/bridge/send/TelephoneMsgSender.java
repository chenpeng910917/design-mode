package com.design.pattern.structure.bridge.send;

import lombok.extern.slf4j.Slf4j;

/**
 * 手机短信消息发送
 *
 * @author chenpeng
 */
@Slf4j
public class TelephoneMsgSender implements MsgSender {

    @Override
    public void send(String message) {
        log.info("手机短信发送消息:{}", message);
    }
}
