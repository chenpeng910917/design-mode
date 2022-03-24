package com.design.pattern.behavior.responsibility;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * 涉黄敏感词过滤
 *
 * @author chenpeng
 */
@Slf4j
public class SexyWordFilter implements SensitiveWordFilter {
    @Override
    public boolean doFilter(String content) {
        if (StringUtils.isBlank(content)) {
            log.info("要过滤的内容为空");
            return false;
        }
        if (StringUtils.containsAny(content,"黄")) {
            log.info("涉黄敏感词,内容:{}", content);
            return true;
        }
        return false;
    }
}
