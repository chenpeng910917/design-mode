package com.design.mode.createtype.singleton;

import java.lang.reflect.Constructor;

/**
 * 单例模式例子
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 1、单例类只能有一个实例。
 * 2、单例类必须自己创建自己的唯一实例。
 * 3、单例类必须给所有其他对象提供这一实例。
 * 单例分为线程唯一、进程唯一、集群唯一(本次案例已进程唯一当案例)
 * 线程唯一：可以使用HashMap 线程id为key 对下为value ThreadLocal底层实现原理就是基于HashMap
 * 进程唯一: 本次案例已进程唯一当案例
 * 集群唯一: 为了保证任何时刻，在进程间都只有一份对象存在，一个进程在获取到对象之后，需要对对象加锁，避免其他进程再将其获取。
 * 在进程使用完这个对象之后，还需要显式地将对象从内存中删除，并且释放对对象的加锁。
 * 反射方式会破坏掉单例  构造方式判断 todo atomic计数 抛异常
 * <p>
 * 应用场景：idGenerate生成器、Log日志对象等
 * 问题：为什么数据库连接池不设计为单例模式 答：有多个连接池时不能扩展
 * <p>
 * 单例缺点:
 * 单例对 OOP 特性的支持不友好
 * 单例会隐藏类之间的依赖关系
 * 单例对代码的扩展性不友好
 * 单例对代码的可测试性不友好
 * 单例不支持有参数的构造函数
 * todo 解决方案：使用工厂模式、ioc容器 例如：spring BeanFactory
 *
 * @author chenpeng
 */
public class SingletonDemo {

    /**
     * 在启动jvm参数中添加 -XX:+TraceClassLoading 查看加载情况
     */
    public static void main(String[] args) {
        // 饿汉模式 建议使用
        hungryMan();
        // 饿汉静态内部类模式 明确要求需要延迟加载
        hungryManStaticInner();
        // 懒汉模式 不建议使用
        slacker();
        // 双重检查
        doubleCheck();
        // 枚举模式
        singletonEnum();
        //反射方式破坏原有单例
        reflexDestruction();
        // 反射方式 防止破坏
        reflex();

    }

    /**
     * 使用反射破坏单例模式
     * 查看源码反射中对枚举类型进行了限制 todo
     * java.lang.reflect.Constructor.newInstance    if ((clazz.getModifiers() & Modifier.ENUM) != 0)
     */
    private static void reflexDestruction() {
        try {
            // 正常方式获取对象
            HungryManSingleton singleton = HungryManSingleton.SINGLETON;

            // 反射
            Class<?> clazz = Class.forName("com.design.mode.createtype.singleton.HungryManSingleton");
            // 获取私有构造方法
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            // 初始化
            HungryManSingleton hungryManSingleton = (HungryManSingleton) declaredConstructor.newInstance();

            System.out.println("正常方式singleton：" + singleton);
            System.out.println("反射方式hungryManSingleton:" + hungryManSingleton);
            // 说不是一个对象 反射已经破坏原有的方式
            System.out.println("反射方式hungryManSingleton==正常方式singleton：" + (hungryManSingleton == singleton));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用反射不被破坏 todo 为什么先反射 在使用也不行  不调用正常模式也会禁止反射
     */
    private static void reflex() {
        try {
            // 正常方式获取对象
            HungryManDestructionSingleton singleton = HungryManDestructionSingleton.SINGLETON;

            // 反射
            Class<?> clazz = Class.forName("com.design.mode.createtype.singleton.HungryManDestructionSingleton");
            // 获取私有构造方法
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();
            // 设置true时生效
//            declaredConstructor.setAccessible(true);
            declaredConstructor.setAccessible(false);
            // 初始化
            HungryManDestructionSingleton hungryManDestructionSingleton = (HungryManDestructionSingleton) declaredConstructor.newInstance();

            System.out.println("正常方式singleton：" + singleton);
            System.out.println("反射方式hungryManDestructionSingleton:" + hungryManDestructionSingleton);
            // 说不是一个对象 反射已经破坏原有的方式
            System.out.println("反射方式hungryManDestructionSingleton==正常方式singleton：" + (hungryManDestructionSingleton == singleton));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 饿汉模式
     */
    public static void hungryMan() {
        // 不加载HungryManSingleton 不会打印HungryManSingleton静态代码块中的日志
        // 因为HungryManSingleton常量加了final相当于在SingletonDemo中使用的常量 可以直接看编译后的
        System.out.println(HungryManSingleton.FINAL_CONSTANT);
        // 会加载HungryManSingleton 打印HungryManSingleton静态代码块中的日志
        System.out.println(HungryManSingleton.CONSTANT);
        // 获取饿汉模式单例
        HungryManSingleton instance = HungryManSingleton.SINGLETON;
    }

    /**
     * 饿汉静态内部类模式
     */
    public static void hungryManStaticInner() {
        // 不加载HungryManStaticInnerSingleton 不会打印HungryManStaticInnerSingleton静态代码块中的日志
        // 因为HungryManStaticInnerSingleton常量加了final相当于在SingletonDemo中使用的常量 可以直接看编译后的
        System.out.println(HungryManStaticInnerSingleton.FINAL_CONSTANT);
        // 会加载HungryManSingleton 打印HungryManSingleton静态代码块中的日志
        System.out.println(HungryManStaticInnerSingleton.CONSTANT);
        HungryManStaticInnerSingleton singleton = HungryManStaticInnerSingleton.getSingleton();
    }

    /**
     * 懒汉模式
     */
    public static void slacker() {
        SlackerSingleton instance = SlackerSingleton.getInstance();
    }

    /**
     * 双重检查
     */
    public static void doubleCheck() {
        DoubleCheckSingleton singleton = DoubleCheckSingleton.getSingleton();
    }

    /**
     * 枚举
     */
    public static void singletonEnum() {
        SingletonEnum instance = SingletonEnum.INSTANCE;
    }
}
