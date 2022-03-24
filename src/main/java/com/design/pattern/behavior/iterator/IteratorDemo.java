package com.design.pattern.behavior.iterator;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 迭代器模式例子
 *
 * @author chenpeng
 */
public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("张三");
        names.add("李四");
        names.add("王二麻子");
        // 自定义实现迭代器
        Iterator<String> iterator = new ArrayIterator(names);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            // 执行remove会发生什么 ArrayIterator没有重新实现remove方法 iterator接口中默认实现直接抛异常
            iterator.remove();
            // 迭代遍历过程中新增一条数据会怎么样 死循环
            names.add("刘一");
        }

        ArrayList<String> lists = Lists.newArrayList();
        lists.add("11");
        lists.add("22");
        lists.add("33");
        // java.util.ArrayList.Itr 中的checkForComodification方法判断了 modCount != expectedModCount 时抛异常
        Iterator<String> iterator1 = lists.iterator();

        while (iterator1.hasNext()) {
            // 在next方法中 lastRet赋值为下标值
            System.out.println(iterator1.next());
            // 为了保持数组存储数据的连续性，数组的删除操作会涉及元素的搬移 lastRet  lastRet<0时抛异常 此时可以安全移除数据
            iterator1.remove();
            // modCount != expectedModCount  在add过程中 modCount++
            lists.add("44");
        }
        System.out.println(lists);
    }
}
