package com.design.pattern.structure.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib方法拦截器
 *
 * @author chenpeng
 */
public class CglibMethodInterceptor implements MethodInterceptor {

    /**
     * cglib
     *
     * @param o cglib生成的代理对象
     * @param method 被代理对象的方法
     * @param objects 方法入参
     * @param methodProxy 代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 计算程序开始时间
        long startTime = System.currentTimeMillis();

        // 反射执行方法
        Object invoke = methodProxy.invokeSuper(o, objects);

        // 计算程序结束时间
        long endTime = System.currentTimeMillis();
        // 返回时间
        long responseTime = endTime - startTime;
        // 方法名称
        String apiName = method.getClass().getName() + ":" + method.getName();
        System.out.println(apiName + "程序执行时间:" + responseTime);
        return invoke;
    }
}
