package com.design.mode.creation.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 原型模式例子 原型用的比较少
 *
 * @author chenpeng
 */
public class PrototypePatternDemo {

    public static void main(String[] args) {
        // 使用场景 例如在加载数据库时 需要操作对象信息

        // 浅拷贝
        shallowCopy();

        // 深拷贝
        deepCopy();
    }

    /**
     * 浅拷贝
     */
    private static void shallowCopy() {
        // 创建一个水果对象
        Fruits fruits = new Fruits("香蕉", 1);
        // 浅拷贝
        Fruits cloneFruits = fruits.clone();

        // 判断两个对象是否相等 不是一个对象 克隆会新开辟一个内存空间给克隆对象使用(但是对象中的非基础类型还是拷贝的引用地址)
        System.out.println("fruits和cloneFruits是否是同一个对象" + (fruits == cloneFruits));

        // 在浅克隆中，如果原型对象的成员变量是值类型（八大基本类型，byte,short,int,long,char,double,float,boolean）.那么就直接复制，如果是复杂的类型，（如枚举、对象）就只复制对应的内存地址。
        // 所以在两个对象中String类型的水果名称的引用地址是相同的
        System.out.println("fruits.getName()和 cloneFruits.getName():" + (fruits.getName() == cloneFruits.getName() ? "clone是浅拷贝的" : "clone是深拷贝的"));
    }

    /**
     * 深拷贝
     */
    private static void deepCopy() {
        Body.Head head = new Body.Head("猫脸");
        Body body = new Body(head);

        //深拷贝 在对象Head中重写clone方法 在对象Body clone方法中克隆head方法
        Body clone = body.clone();

        // 判断两个对象是否相等 不是一个对象 克隆会新开辟一个内存空间给克隆对象使用(但是对象中的非基础类型还是拷贝的引用地址)
        System.out.println("body和clone是否是同一个对象" + (body == clone));

        // 判断是否为深拷贝
        System.out.println("body.getHead()和clone.getHead():" + (body.getHead() == clone.getHead() ? "clone是浅拷贝的" : "clone是深拷贝的"));

        System.out.println("--------------------------------------------------------");
        // 真的是深拷贝吗 是不完整的深拷贝 因为最底层的face是String类型
        System.out.println("body.getHead().getFace()和clone.getHead().getFace():" + (body.getHead().getFace() == clone.getHead().getFace() ? "clone是浅拷贝的" : "clone是深拷贝的"));

        System.out.println("--------------------------------------------------------");
        // 深拷贝 序列化
        Body serializeInstance = getSerializeInstance(body);

        // 判断两个对象是否相等 不是一个对象 克隆会新开辟一个内存空间给克隆对象使用(但是对象中的非基础类型还是拷贝的引用地址)
        System.out.println("body和serializeInstance是否是同一个对象" + (body == serializeInstance));

        // 判断是否为深拷贝
        System.out.println("body.getHead()和serializeInstance.getHead():" + (body.getHead() == serializeInstance.getHead() ? "clone是浅拷贝的" : "clone是深拷贝的"));

        // 真的是深拷贝吗 是不完整的深拷贝 因为最底层的face是String类型
        System.out.println("body.getHead().getFace()和serializeInstance.getHead().getFace():" + (body.getHead().getFace() == serializeInstance.getHead().getFace() ? "clone是浅拷贝的" : "clone是深拷贝的"));


    }

    /**
     * 通过序列化方式获取一个深克隆对象
     * 其实就是复制一个全新的对象并且这个对象的引用属性也会单独复制出来
     * 与原对象没有任何关联
     * @param body
     * @return body
     */
    public static Body getSerializeInstance(Body body) {
        try {
            //创建输出流  需要body对象实现序列化Serializable
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(body);
            //创建输入流
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            Body copy = (Body) ois.readObject();
            bos.flush();
            //关闭输出流
            bos.close();
            //关闭输入流
            ois.close();
            return copy;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
