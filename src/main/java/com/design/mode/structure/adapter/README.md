# 适配器模式
应用场景
封装有缺陷的接口设计  
统一多个类的接口设计  AdapterDemo
替换依赖的外部系统  
兼容老版本接口  
适配不同格式的数据  


类适配器：基于继承
对象适配器：基于组合

代理模式：代理模式在不改变原始类接口的条件下，为原始类定义一个代理类，主要目的是控制访问，而非加强功能，这是它跟装饰器模式最大的不同。
桥接模式：桥接模式的目的是将接口部分和实现部分分离，从而让它们可以较为容易、也相对独立地加以改变。
装饰器模式：装饰者模式在不改变原始类接口的情况下，对原始类功能进行增强，并且支持多个装饰器的嵌套使用。
适配器模式：适配器模式是一种事后的补救策略。适配器提供跟原始类不同的接口，而代理模式、装饰器模式提供的都是跟原始类相同的接口。

```java
// 类适配器: 基于继承
public interface ITarget { 
    void f1(); 
    void f2(); 
    void fc(); 
}
public class Adaptee { 
    public void fa() { //... } 
    public void fb() { //... } 
    public void fc() { //... }
}
public class Adaptor extends Adaptee implements ITarget { 
    public void f1() { 
        super.fa(); 
    }
    public void f2() { 
        //...重新实现f2()... 
    }
    // 这里fc()不需要实现，直接继承自Adaptee，这是跟对象适配器最大的不同点
}

// 对象适配器：基于组合
public interface ITarget { 
    void f1(); 
    void f2(); 
    void fc(); 
}
public class Adaptee {
    public void fa() { //... }
    public void fb() { //... } 
    public void fc() { //... } 
}
public class Adaptor implements ITarget { 
    private Adaptee adaptee;
    public Adaptor(Adaptee adaptee) { 
        this.adaptee = adaptee; 
    }
    public void f1() { 
        adaptee.fa(); //委托给Adaptee 
    }
    public void f2() { 
        //...重新实现f2()... 
    }
    public void fc() { 
        adaptee.fc(); 
    } 
}
```
针对这两种实现方式，在实际的开发中，到底该如何选择使用哪一种呢？判断的标准主要有
两个，一个是 Adaptee 接口的个数，另一个是 Adaptee 和 ITarget 的契合程度。

如果 Adaptee 接口并不多，那两种实现方式都可以。
如果 Adaptee 接口很多，而且 Adaptee 和 ITarget 接口定义大部分都相同，那我们推
荐使用类适配器，因为 Adaptor 复用父类 Adaptee 的接口，比起对象适配器的实现方
式，Adaptor 的代码量要少一些。
如果 Adaptee 接口很多，而且 Adaptee 和 ITarget 接口定义大部分都不相同，那我们
推荐使用对象适配器，因为组合结构相对于继承更加灵活。


JDK应用例子 java.util.Collections.enumeration
老版本的 JDK 提供了 Enumeration 类来遍历容器。新版本的 JDK 用 Iterator 类替代 Enumeration 类来遍历容器。
为了兼容老的客户端代码（使用老版本 JDK 的代码），我们保留了 Enumeration 类，并且在 Collections 类中，
仍然保留了 enumaration() 静态方法（因为我们一般都是通过这个静态函数来创建一个容器的 Enumeration 类对象）。

spring中用到的适配器
controller 针对注解、配置文件方式、servlet方式 统一使用HandAdapter适配类来处理