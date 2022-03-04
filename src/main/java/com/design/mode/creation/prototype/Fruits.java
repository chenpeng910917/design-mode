package com.design.mode.creation.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 水果类
 *
 * @author chenpeng
 */
@Data
@AllArgsConstructor
public class Fruits implements Cloneable {

    /**
     * 水果名称
     */
    private String name;

    /**
     * 水果数量
     */
    private int num;

    /**
     * 浅拷贝克隆方法
     * @return 水果对象
     */
    @Override
    public Fruits clone() {
        try {
            Fruits clone = (Fruits) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
