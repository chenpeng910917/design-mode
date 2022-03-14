package com.design.mode.behavior.mediator;

import java.util.Date;

/**
 * 聊天室
 *
 * @author chenpeng
 */
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString()
                + " [" + user.getName() + "] : " + message);
    }
}