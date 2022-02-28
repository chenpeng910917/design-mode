package com.design.mode.structure.proxy;

/**
 * 代理模式例子
 *
 * @author chenpeng
 */
public class ProxyDemo {
    public static void main(String[] args) {

        // 不使用代理模式 目标要输出登录和注册的程序执行时间 此方式缺点是入侵代码
        UserAction userAction = new UserAction();
        // 注册
        userAction.register("张三", "123456");
        // 登录
        userAction.login("张三", "123456");

        // 使用代理模式 在不入侵代码的情况下 进行登录和注册的输出程序执行时间 缺点 如果需要代理的类或方法比较多 则需要实现多个代理类
        UserActionServiceProxy userActionServiceProxy = new UserActionServiceProxy();
        // 委托注册
        userActionServiceProxy.register("张三", "123456");
        // 委托登录
        userActionServiceProxy.login("张三", "123456");

        // 动态代理 基于反射
        DynamicProxy dynamicProxy = new DynamicProxy();

        UserActionServiceImpl userActionService = new UserActionServiceImpl();
        UserActionService proxy = (UserActionService) dynamicProxy.createProxy(new UserActionServiceImpl());
        proxy.login("张三", "123456");

    }
}
