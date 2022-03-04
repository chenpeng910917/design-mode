package com.design.mode.creation.singleton;

/**
 * 双重检查单例模式
 * 优点:支持延迟加载、支持高并发
 *
 * @author chenpeng
 */
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton SINGLETON;

    /**
     * 此处需不需要加volatile关键字 会不会有指令重排序问题
     * 因为在创建DoubleCheckSingleton对象时先初始化和先开辟内存空间是有先后顺序的
     * 如果线程A先开辟内存空间 线程B这时访问 SINGLETON就不为null但是也没有实例化 在使用时会报错
     * 低版本java会有 高版本在JDK内部通过原子操作已经禁止重排序问题
     */
//    private volatile static DoubleCheckSingleton SINGLETON;


    public static DoubleCheckSingleton getSingleton() {
        if (SINGLETON == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (SINGLETON == null) {
                    SINGLETON = new DoubleCheckSingleton();
                }
            }
        }
        return SINGLETON;
    }

    /**
     * 私有化构造方法 防止外部类通过new的方式实例化对象
     */
    private DoubleCheckSingleton() {
        System.out.println("加载双重检查单例模式加载DoubleCheckSingleton构造器");
    }
}
