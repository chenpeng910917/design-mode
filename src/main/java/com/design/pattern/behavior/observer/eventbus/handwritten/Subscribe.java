package com.design.pattern.behavior.observer.eventbus.handwritten;

import com.google.common.annotations.Beta;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 订阅注解
 *
 * @author chenpeng
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Beta
public @interface Subscribe {
}
