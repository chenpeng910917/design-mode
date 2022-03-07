package com.design.mode.structure.proxy.cglib;

/**
 * 用户行为
 *
 * @author chenpeng
 */
public class UserActionCglib {

    /**
     * 用户登录
     *
     * @param name     用户名
     * @param password 密码
     * @return 用户信息
     */
    public String login(String name, String password) {
        String userInfo = String.format("欢迎用户:%s登录,本次登录密码为:%s", name, password);
        System.out.println(userInfo);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    /**
     * 用户注册
     *
     * @param name     用户名
     * @param password 密码
     * @return 用户信息
     */
    public String register(String name, String password) {
        String userInfo = String.format("注册成功，用户名为:%s,密码为:%s", name, password);
        System.out.println(userInfo);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userInfo;
    }
}
