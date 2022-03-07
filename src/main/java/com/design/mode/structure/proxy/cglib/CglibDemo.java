package com.design.mode.structure.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * cglib动态代理
 *
 * @author chenpeng
 */
public class CglibDemo {
    public static void main(String[] args) {
        // 通过CGLIB动态代理获取对象的过程
        Enhancer enhancer = new Enhancer();
        //设置enhancer对象的父类
        enhancer.setSuperclass(UserActionCglib.class);
        //设置enhancer的回调对象
        enhancer.setCallback(new CglibMethodInterceptor());
        //创建代理对象
        UserActionCglib proxy = (UserActionCglib) enhancer.create();
        //通过代理对象调用目标方法
        proxy.login("张三", "123456");
        proxy.register("张三", "123456");
    }
}
