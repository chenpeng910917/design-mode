package com.design.mode.createtype.singleton;

/**
 * 枚举单例
 * 虚拟机保证的只创建一次 通过查询字节码看原理 创建了一个静态的INSTANCE
 *
 * 编译项目
 * cd target/classes/com/design/mode/singleton
 * javap -c SingletonEnum.class 查看字节码  javap -v SingletonEnum.class 更详细
 *
 * @author chenpeng
 */

public enum SingletonEnum {
    /**
     * 实例
     */
    INSTANCE();

    static {
        System.out.println("加载枚举单例");
    }

    public void get() {
        System.out.println("枚举");
    }

}
