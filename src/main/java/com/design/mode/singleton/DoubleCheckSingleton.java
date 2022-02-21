package com.design.mode.singleton;

/**
 * 双重检查单例模式
 * 优点:支持延迟加载、支持高并发
 *
 * @author chenpeng
 * @date 2022/2/17
 */
public class DoubleCheckSingleton {

    private static DoubleCheckSingleton SINGLETON;

    /**
     * 此处需不需要加volatile关键字 会不会有指令重排序问题
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
}
