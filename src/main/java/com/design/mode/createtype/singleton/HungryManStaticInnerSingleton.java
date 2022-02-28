package com.design.mode.createtype.singleton;

/**
 * 饿汉静态内部类
 * 缺点：只能使用静态方法
 * 优点：毕饿汉模式好在可以延迟加载
 *
 * @author chenpeng
 * @date 2022/2/15
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
        System.out.println("加载饿汉静态内部类HungryManStaticInnerSingleton");
    }

    public static HungryManStaticInnerSingleton getSingleton() {
        return SingletonHolder.SINGLETON;
    }

    /**
     * 通过静态内部类的加载方式达到延迟加载效果 在调用HungryManStaticInnerSingleton时不会加载SingletonHolder
     * 只有当SingletonHolder被使用时才会加载
     */
    private static class SingletonHolder {
        static {
            System.out.println("加载饿汉静态内部类SingletonHolder");
        }
        /**
         * SINGLETON设置为静态不可变的是因为 HungryManSingleton类加载时就初始化SINGLETON
         * 设置为private是因为不允许外部类进行实例化
         * jvm保证的HungryManStaticInnerSingleton只会被实例化一次 类加载机制 只会在首次使用时加载一次
         */
        private static final HungryManStaticInnerSingleton SINGLETON = new HungryManStaticInnerSingleton();
    }
}
