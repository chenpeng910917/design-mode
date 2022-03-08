package com.design.mode.behavior.responsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * 职责链模式例子
 *
 * @author chenpeng
 */
@Slf4j
public class ResponsibilityDemo {
    public static void main(String[] args) {
        String content = "本条内容为广告内容";
//        String content = "本条内容为涉黄内容";
        // 接口实现方式过滤器
        SensitiveWordFilterChain sensitiveWordFilterChain = new SensitiveWordFilterChain();
        // 添加涉黄过滤器
        sensitiveWordFilterChain.addFilter(new SexyWordFilter());
        // 添加广告过滤器
        sensitiveWordFilterChain.addFilter(new AdvertisementWordFilter());

        boolean filter = sensitiveWordFilterChain.filter(content);
        if (filter) {
            log.info("本条内容已被敏感词过滤，内容:{}", content);
        }

        // 继承抽象类+链表方式+递归
    }
}
