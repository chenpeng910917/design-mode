package com.design.mode.createtype.builder;

/**
 * @author chenpeng
 * @date 2022/2/24
 */
public class BuilderDemo {
    public static void main(String[] args) {
        // 不使用建造者模式 参数较少时还行 参数多时可读性和易用性就会变差 使用构造参数时 参数顺序容易搞错
        ResourcePoolConfig mysqlPool = new ResourcePoolConfig("mysqlPool", 10, 10, 1);
        // 如果使用对象set传递 解决顺序问题等 但是如果参数在创建对象时设置好大小不允许后续修改 则此方式则不适用
        ResourcePoolConfigSet mysqlPoolSet = new ResourcePoolConfigSet("mysqlPool");
        mysqlPoolSet.setMaxTotal(10);
        mysqlPoolSet.setMaxIdle(10);
        mysqlPoolSet.setMinIdle(1);

        //使用建造者模式
        ResourcePoolConfigBuilder mysqlPoolBuilder = new ResourcePoolConfigBuilder.Builder()
                .setName("mysqlPool")
                .setMaxTotal(10)
                .setMaxIdle(10)
                .setMinIdle(1)
                .build();
    }
}
