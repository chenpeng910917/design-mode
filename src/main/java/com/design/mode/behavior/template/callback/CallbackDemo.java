package com.design.mode.behavior.template.callback;

/**
 * @author chenpeng
 */
public class CallbackDemo {

    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.queryUser(1L);
    }

}
