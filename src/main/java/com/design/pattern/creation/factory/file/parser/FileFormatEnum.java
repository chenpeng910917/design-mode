package com.design.pattern.creation.factory.file.parser;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 文件后缀格式枚举
 *
 * @author chenpeng
 */
@Getter
@AllArgsConstructor
public enum FileFormatEnum {

    /**
     * json格式
     */
    JSON("json"),
    /**
     * xml格式
     */
    XML("xml"),
    /**
     * yaml格式
     */
    YAML("yaml"),
    /**
     * properties格式
     */
    PROPERTIES("properties"),
    ;

    /**
     * 文件后缀格式
     */
    String suffix;
}
