package com.design.mode.createtype.builder;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 资源池配置 不使用建造者模式
 *
 * @author chenpeng
 */
@Data
public class ResourcePoolConfigSet {

    /**
     * 默认最大值
     */
    private static final int DEFAULT_MAX_TOTAL = 8;
    /**
     * 默认最大空闲值
     */
    private static final int DEFAULT_MAX_IDLE = 8;
    /**
     * 默认最新空闲值
     */
    private static final int DEFAULT_MIN_IDLE = 0;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 最大值
     */
    private int maxTotal = DEFAULT_MAX_TOTAL;
    /**
     * 最大空闲值
     */
    private int maxIdle = DEFAULT_MAX_IDLE;
    /**
     * 最小空闲值
     */
    private int minIdle = DEFAULT_MIN_IDLE;

    /**
     * 不使用建造者模式
     *
     * @param name     资源名称
     */
    public ResourcePoolConfigSet(String name) {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("资源名称不能为空");
        }
        this.name = name;
    }

    public void setMaxTotal(Integer maxTotal) {
        if (maxTotal != null) {
            if (maxTotal <= 0) {
                throw new RuntimeException("最大值不能小于0");
            }
            this.maxTotal = maxTotal;
        }
    }

    public void setMaxIdle(Integer maxIdle) {
        if (maxIdle != null) {
            if (maxIdle < 0 || maxIdle > maxTotal) {
                throw new RuntimeException("最大空闲值不能小于0或大于最大值");
            }
            this.maxIdle = maxIdle;
        }
    }

    public void setMinIdle(Integer minIdle) {
        if (minIdle != null) {
            if (minIdle < 0 || minIdle > maxIdle) {
                throw new RuntimeException("最小空闲值不能小于0或大于最大空闲值");
            }
            this.minIdle = minIdle;
        }
    }
}
