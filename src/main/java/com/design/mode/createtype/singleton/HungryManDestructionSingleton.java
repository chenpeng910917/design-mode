package com.design.mode.createtype.singleton;

/**
 * @author chenpeng
 * @date 2022/2/28
 */
public class HungryManDestructionSingleton {

    /**
     * 常量使用final修饰 则外部类引用时是不加载HungryManDestructionSingleton这个类的
     */
    public static final int FINAL_CONSTANT = 1;
    /**
     * 不适用final修饰 则外部类引用时加载HungryManDestructionSingleton这个类
     */
    public static int CONSTANT = 1;

    static {
        System.out.println("加载饿汉模式HungryManDestructionSingleton静态代码块");
    }

    /**
     * SINGLETON设置为静态不可变的是因为 HungryManDestructionSingleton类加载时就初始化SINGLETON
     * 设置为final是因为不允许外部类进行改动
     * jvm保证的HungryManDestructionSingleton只会被实例化一次 类加载机制 只会在首次使用时加载一次
     */
    public static final HungryManDestructionSingleton SINGLETON = new HungryManDestructionSingleton();

    /**
     * 私有化构造方法 防止外部类通过new的方式实例化对象
     */
    private HungryManDestructionSingleton() {
        if (SINGLETON != null) {
            throw new RuntimeException("单例构造器禁止反射调用！");
        }
        System.out.println("加载饿汉防止反射破坏模式HungryManDestructionSingleton构造器");
    }

}
