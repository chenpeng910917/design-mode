package com.design.pattern.creation.builder;

/**
 * 建造者模式例子
 *
 * @author chenpeng
 */
public class BuilderDemo {
    public static void main(String[] args) {
        // 资源池 不使用建造者模式 参数较少时还行 参数多时可读性和易用性就会变差 使用构造参数时 参数顺序容易搞错
        ResourcePoolConfig mysqlPool = new ResourcePoolConfig("mysqlPool", 10, 10, 1);
        // 如果使用对象set传递 解决顺序问题等 解决不了组合参数校验问题
        ResourcePoolConfigSet mysqlPoolSet = new ResourcePoolConfigSet("mysqlPool");
        mysqlPoolSet.setMaxTotal(10);
        mysqlPoolSet.setMaxIdle(10);
        mysqlPoolSet.setMinIdle(1);

        //使用建造者模式 参数顺序容易搞错 解决了组合参数校验问题
        ResourcePoolConfigBuilder mysqlPoolBuilder = new ResourcePoolConfigBuilder.Builder()
                .setName("mysqlPool")
                .setMaxTotal(10)
                .setMaxIdle(10)
                .setMinIdle(1)
                .build();
    }
}
