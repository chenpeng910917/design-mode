package com.design.pattern.creation.builder;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 资源池配置 建造者模式
 *
 * @author chenpeng
 */
@Data
public class ResourcePoolConfigBuilder {

    /**
     * 资源名称
     */
    private String name;
    /**
     * 最大值
     */
    private int maxTotal;
    /**
     * 最大空闲值
     */
    private int maxIdle;
    /**
     * 最小空闲值
     */
    private int minIdle;

    public ResourcePoolConfigBuilder(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    @Data
    public static class Builder {
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

        public ResourcePoolConfigBuilder build() {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("资源名称不能为空");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("最大空闲值不能大于最大值");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("最小空闲着补鞥呢大于最大值或不能大于最大空闲值");
            }
            return new ResourcePoolConfigBuilder(this);
        }

        public Builder setName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("资源名称不能为空");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(Integer maxTotal) {
            if (maxTotal != null) {
                if (maxTotal <= 0) {
                    throw new RuntimeException("最大值不能小于0");
                }
                this.maxTotal = maxTotal;
            }
            return this;
        }

        public Builder setMaxIdle(Integer maxIdle) {
            if (maxIdle != null) {
                if (maxIdle < 0 || maxIdle > maxTotal) {
                    throw new RuntimeException("最大空闲值不能小于0或大于最大值");
                }
                this.maxIdle = maxIdle;
            }
            return this;
        }

        public Builder setMinIdle(Integer minIdle) {
            if (minIdle != null) {
                if (minIdle < 0 || minIdle > maxIdle) {
                    throw new RuntimeException("最小空闲值不能小于0或大于最大空闲值");
                }
                this.minIdle = minIdle;
            }
            return this;
        }
    }
}
