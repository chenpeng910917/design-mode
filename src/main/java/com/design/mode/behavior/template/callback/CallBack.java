package com.design.mode.behavior.template.callback;

/**
 * 回调接口
 *
 * @author chenpeng
 */
public interface CallBack<T> {

    /**
     * 执行
     *
     * @param parser 解析器
     * @return 返回结果
     */
    T methodToCallback(DataParser parser);
}
