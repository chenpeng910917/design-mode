package com.design.mode.behavior.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 数组迭代器
 *
 * @author chenpeng
 */
public class ArrayIterator<E> implements Iterator<E> {
    /**
     * 光标
     */
    private int cursor;

    private ArrayList<E> arrayList;

    public ArrayIterator(ArrayList<E> arrayList) {
        this.cursor = 0;
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        // 注意这里，cursor(光标)在指向最后一个元素的时候，hasNext()仍旧返回true。
        return cursor != arrayList.size();
    }

    /**
     * 获取当前下标内容 下标加1
     *
     * @return 内容
     */
    @Override
    public E next() {
        if (cursor >= arrayList.size()) {
            throw new NoSuchElementException();
        }
        cursor++;
        return arrayList.get(cursor);
    }
}

