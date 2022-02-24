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
 * @Target 属性用于注明此注解用在什么位置,
 * ElementType.TYPE表示可用在类、接口、枚举上等
 *
 * 当用了@Inherited修饰的注解的@Retention是RetentionPolicy.RUNTIME，则增强了继承性，在反射中可以获取得到
 *
 * @Retention 属性表示所定义的注解什么时候有效,
 * RetentionPolicy.RUNTIME表示在运行时有效
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
