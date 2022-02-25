package com.design.mode.structure.proxy;

/**
 * 用户行为实现类
 *
 * @author chenpeng
 */
public class UserActionServiceImpl implements UserActionService {
    @Override
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

    @Override
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
