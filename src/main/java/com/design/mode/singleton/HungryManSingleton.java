package com.design.mode.singleton;

/**
 * 饿汉模式
 * 缺点：不能延迟加载 在HungryManSingleton被调用时就一定会加载
 *
 * @author chenpeng
 * @date 2022/2/15
 */
public class HungryManSingleton {

    /**
     * 常量使用final修饰 则外部类引用时是不加载HungryManSingleton这个类的
     */
    public static final int FINAL_CONSTANT = 1;
    /**
     * 不适用final修饰 则外部类引用时加载HungryManSingleton这个类
     */
    public static int CONSTANT = 1;

    static {
        System.out.println("加载饿汉模式HungryManSingleton");
    }

    /**
     * SINGLETON设置为静态不可变的是因为 HungryManSingleton类加载时就初始化SINGLETON
     * 设置为private是因为不允许外部类进行实例化
     * jvm保证的HungryManSingleton只会被实例化一次 类加载机制 只会在首次使用时加载一次
     */
    private static final HungryManSingleton SINGLETON = new HungryManSingleton();

    public static HungryManSingleton getInstance() {
        return SINGLETON;
    }

}
