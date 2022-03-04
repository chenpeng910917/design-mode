package com.design.mode.creation.singleton;

/**
 * 饿汉静态内部类
 * 缺点：只能使用静态方法
 * 优点：毕饿汉模式好在可以延迟加载
 *
 * @author chenpeng
 */
public class HungryManStaticInnerSingleton {

    /**
     * 常量使用final修饰 则外部类引用时是不加载HungryManSingleton这个类的
     */
    public static final int FINAL_CONSTANT = 1;
    /**
     * 不适用final修饰 则外部类引用时加载HungryManSingleton这个类
     */
    public static int CONSTANT = 1;
    static {
        System.out.println("加载饿汉静态内部类HungryManStaticInnerSingleton静态代码块");
    }

    public static HungryManStaticInnerSingleton getSingleton() {
        return SingletonHolder.SINGLETON;
    }

    /**
     * 私有化构造方法 防止外部类通过new的方式实例化对象
     */
    private HungryManStaticInnerSingleton() {
        System.out.println("加载饿汉静态内部类HungryManStaticInnerSingleton构造器");
    }

    /**
     * 通过静态内部类的加载方式达到延迟加载效果 在调用HungryManStaticInnerSingleton时不会加载SingletonHolder
     * 只有当SingletonHolder被使用时才会加载
     * 静态内部类编译后是两个类 所以能实现懒加载 非静态内部类 需要实例化在能使用
     */
    private static class SingletonHolder {
        static {
            System.out.println("加载饿汉静态内部类SingletonHolder静态代码块");
        }
        /**
         * SINGLETON设置为静态不可变的是因为 HungryManSingleton类加载时就初始化SINGLETON
         * 设置为private是因为不允许外部类进行实例化
         * jvm保证的HungryManStaticInnerSingleton只会被实例化一次 类加载机制 只会在首次使用时加载一次
         *
         */
        private static final HungryManStaticInnerSingleton SINGLETON = new HungryManStaticInnerSingleton();
    }
}
