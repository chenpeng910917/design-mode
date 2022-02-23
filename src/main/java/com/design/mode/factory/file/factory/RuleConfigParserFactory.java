package com.design.mode.factory.file.factory;

import com.design.mode.factory.file.parser.RuleConfigParser;

/**
 * 文件解析工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public interface RuleConfigParserFactory {

    /**
     * 创建文件解析工厂
     * @return 解析器对象
     */
    RuleConfigParser createParser();

}
