package com.design.mode.creation.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 身体类
 *
 * @author chenpeng
 */
@AllArgsConstructor
@Data
public class Body implements Cloneable, Serializable {

    /**
     * 头部信息
     */
    private Head head;

    @Override
    public Body clone() {
        try {
            Body clone = (Body) super.clone();
            clone.head = head.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * 头部
     */
    @AllArgsConstructor
    @Data
    static class Head implements Cloneable, Serializable {
        private String face;

        @Override
        public Head clone() {
            try {
                Head clone = (Head) super.clone();
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

}

