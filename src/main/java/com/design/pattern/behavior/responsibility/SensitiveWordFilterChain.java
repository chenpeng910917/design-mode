package com.design.pattern.behavior.responsibility;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 敏感词过滤链
 *
 * @author chenpeng
 */
public class SensitiveWordFilterChain {
    /**
     * 过滤器
     */
    private List<SensitiveWordFilter> filters = Lists.newArrayList();

    /**
     * 添加过滤器
     *
     * @param filter 过滤器
     */
    public void addFilter(SensitiveWordFilter filter) {
        filters.add(filter);
    }

    /**
     * 过滤
     * @param content 内容
     * @return 是否过滤
     */
    public boolean filter(String content) {
        for (SensitiveWordFilter filter : filters) {
            if (filter.doFilter(content)) {
                return true;
            }
        }
        return false;
    }
}
