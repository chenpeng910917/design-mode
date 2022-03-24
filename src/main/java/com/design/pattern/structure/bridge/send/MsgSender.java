package com.design.pattern.structure.bridge.send;

/**
 * 消息发送接口
 *
 * @author chenpeng
 */
public interface MsgSender {

    /**
     * 消息发送
     *
     * @param message 消息内容
     */
    void send(String message);
}
