package com.design.mode.structure.proxy;

/**
 * 用户行为代理实现类
 *
 * @author chenpeng
 */
public class UserActionServiceProxy implements UserActionService {

    private final UserActionServiceImpl userActionService = new UserActionServiceImpl();

    @Override
    public String login(String name, String password) {
        // 计算程序开始时间
        long startTime = System.currentTimeMillis();

        // 委托
        String login = userActionService.login(name, password);

        // 计算程序结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("代理模式本次用户登录程序执行时间:" + (endTime - startTime));
        return login;
    }

    @Override
    public String register(String name, String password) {
        // 计算程序开始时间
        long startTime = System.currentTimeMillis();

        // 委托
        String register = userActionService.register(name, password);

        // 计算程序结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("代理模式本次用户注册程序执行时间:" + (endTime - startTime));
        return register;
    }
}
