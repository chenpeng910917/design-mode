# 模板模式
模板 是抽象类中定义final(避免子类重写)骨架方法 在定义其他抽象方法(强制子类必须实现的方法)

模板模式有两大作用：
复用和扩展。
其中，复用指的是，所有的子类可以复用父类中提供的模板方法的代码。
扩展指的是，框架通过模板模式提供功能扩展点，让框架用户可以在不修改框架源码的情况下，基于扩展点定制化框架的功能。

JdbcTemplate就属于回调函数
org.springframework.jdbc.core.JdbcTemplate#query(java.lang.String, org.springframework.jdbc.core.ResultSetExtractor<T>)
回调函数
```java
public interface ICallback {
  void methodToCallback();
}
public class BClass {
  public void process(ICallback callback) {
    //...
    callback.methodToCallback();
    //...
  }
}
public class AClass {
  public static void main(String[] args) {
    BClass b = new BClass();
    b.process(new ICallback() { //回调对象
      @Override
      public void methodToCallback() {
        System.out.println("Call back me.");
      }
    });
  }
}
```

回调可以细分为同步回调和异步回调。从应用场景上来看，同步回调看起来更像模板模式，
异步回调看起来更像观察者模式。回调跟模板模式的区别，更多的是在代码实现上，而非应用场景上。
回调基于组合关系来实现，模板模式基于继承关系来实现，回调比模板模式更加灵活。


hook 钩子