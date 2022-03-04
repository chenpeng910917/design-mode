package com.design.mode.creation.singleton;

/**
 * 饿汉模式
 * 缺点：不能延迟加载 在HungryManSingleton被调用时就一定会加载
 * 有人觉得这种实现方式不好，因为不支持延迟加载，如果实例占用资源多（比如占用内存多）或初始化耗时长（比如需要加载各种配置文件），
 * 提前初始化实例是一种浪费资源的行为。最好的方法应该在用到的时候再去初始化。
 * <p>
 * 如果初始化耗时长，那我们最好不要等到真正要用它的时候，才去执行这个耗时长的初始化过程，
 * 这会影响到系统的性能（比如，在响应客户端接口请求的时候，做这个初始化操作，
 * 会导致此请求的响应时间变长，甚至超时）。采用饿汉式实现方式，将耗时的初始化操作，
 * 提前到程序启动的时候完成，这样就能避免在程序运行的时候，再去初始化导致的性能问题。
 * <p>
 * 如果实例占用资源多，按照 fail-fast 的设计原则（有问题及早暴露），那我们也希望在程
 * 序启动时就将这个实例初始化好。如果资源不够，就会在程序启动的时候触发报错（比如
 * Java 中的 PermGen Space OOM），我们可以立即去修复。这样也能避免在程序运行一
 * 段时间后，突然因为初始化这个实例占用资源过多，导致系统崩溃，影响系统的可用性。
 *
 * @author chenpeng
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
        System.out.println("加载饿汉模式HungryManSingleton静态代码块");
    }

    /**
     * SINGLETON设置为静态不可变的是因为 HungryManSingleton类加载时就初始化SINGLETON
     * 设置为final是因为不允许外部类进行改动
     * jvm保证的HungryManSingleton只会被实例化一次 类加载机制 只会在首次使用时加载一次
     */
    public static final HungryManSingleton SINGLETON = new HungryManSingleton();

    /**
     * 私有化构造方法 防止外部类通过new的方式实例化对象
     */
    private HungryManSingleton() {
        System.out.println("加载饿汉模式HungryManSingleton构造器");
    }

}
