package com.design.pattern.behavior.responsibility;

/**
 * 敏感词过滤
 *
 * @author chenpeng
 */
public interface SensitiveWordFilter {

    /**
     * 过滤
     * @param content 内容
     * @return 是否过滤
     */
    boolean doFilter(String content);
}
