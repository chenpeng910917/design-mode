package com.design.mode.factory.file.annotations;

import com.design.mode.factory.file.parser.FileFormatEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 策略注解
 * 实现类 {@link StrategyFactory}
 *
 * @author chenpeng
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ParserStrategyAnnotation {

    /**
     * 文件解析类型
     *
     * @return 文件解析枚举
     */
    FileFormatEnum fileFormat();
}
