package com.design.mode.createtype.singleton;

/**
 * 懒汉单例模式
 * 懒汉式的缺点也很明显，我们给 getInstance() 这个方法加了一把大锁
 * （synchronzed），导致这个函数的并发度很低。量化一下的话，并发度是 1，也就相当于
 * 串行操作了。而这个函数是在单例使用期间，一直会被调用。如果这个单例类偶尔会被用
 * 到，那这种实现方式还可以接受。但是，如果频繁地用到，那频繁加锁、释放锁及并发度低
 * 等问题，会导致性能瓶颈，这种实现方式就不可取了。
 *
 * @author chenpeng
 * @date 2022/2/16
 */
public class SlackerSingleton {

    private static SlackerSingleton singleton;

    /**
     * 通过锁的方式限制只能实例化一次SlackerSingleton对象
     * 锁方法的原因是 singleton 已设置为私有的不能通过new方式实例化
     */
    public static synchronized SlackerSingleton getInstance() {
        if (singleton == null) {
            singleton = new SlackerSingleton();
        }
        return singleton;
    }
}
