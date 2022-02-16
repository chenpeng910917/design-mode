package com.design.mode.singleton;

/**
 * 单例模式例子
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 1、单例类只能有一个实例。
 * 2、单例类必须自己创建自己的唯一实例。
 * 3、单例类必须给所有其他对象提供这一实例。
 *
 * @author chenpeng
 * @date 2022/2/15
 */
public class SingletonDemo {

    /**
     * 在启动jvm参数中添加 -XX:+TraceClassLoading 查看加载情况
     */
    public static void main(String[] args) {
        // 饿汉模式
        hungryMan();
        // 饿汉静态内部类模式
        hungryManStaticInner();
    }

    public static void hungryMan() {
        // 不加载HungryManSingleton 不会打印HungryManSingleton静态代码块中的日志
        // 因为HungryManSingleton常量加了final相当于在SingletonDemo中使用的常量
        System.out.println(HungryManSingleton.FINAL_CONSTANT);
        // 会加载HungryManSingleton 打印HungryManSingleton静态代码块中的日志
        System.out.println(HungryManSingleton.CONSTANT);
        // 获取饿汉模式单例
        HungryManSingleton instance = HungryManSingleton.getInstance();
    }

    public static void hungryManStaticInner() {
        // 不加载HungryManStaticInnerSingleton 不会打印HungryManStaticInnerSingleton静态代码块中的日志
        // 因为HungryManStaticInnerSingleton常量加了final相当于在SingletonDemo中使用的常量
        System.out.println(HungryManStaticInnerSingleton.FINAL_CONSTANT);
        // 会加载HungryManSingleton 打印HungryManSingleton静态代码块中的日志
        System.out.println(HungryManStaticInnerSingleton.CONSTANT);
        HungryManStaticInnerSingleton singleton = HungryManStaticInnerSingleton.getSingleton();
    }
}
