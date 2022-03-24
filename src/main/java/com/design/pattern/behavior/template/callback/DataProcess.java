package com.design.pattern.behavior.template.callback;

/**
 * 数据处理
 *
 * @author chenpeng
 */
public class DataProcess {

    public <T> T process(String param) {
        param = param + "处理";
        String finalParam = param;
        /**
         * 匿名内部类
         */
        class ProcessCallBack implements CallBack<T> {

            ProcessCallBack() {}

            @Override
            public T methodToCallback(DataParser parser) {
                // 执行
                parser.parser(finalParam);
                return null;
            }
        }

        ProcessCallBack processCallBack = new ProcessCallBack();
        T methodToCallback = processCallBack.methodToCallback(new DataParser());
        return methodToCallback;
    }
}
