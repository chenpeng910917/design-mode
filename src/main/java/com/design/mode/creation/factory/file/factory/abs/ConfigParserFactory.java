package com.design.mode.creation.factory.file.factory.abs;

import com.design.mode.creation.factory.file.parser.RuleConfigParser;
import com.design.mode.creation.factory.file.parser.abs.SystemConfigParser;

/**
 * 文件解析工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public interface ConfigParserFactory {

    /**
     * 创建文件解析工厂
     * @return 解析器对象
     */
    RuleConfigParser createRuleParser();

    /**
     * 系统配置文件解析工厂
     * @return 解析器对象
     */
    SystemConfigParser createSystemParser();

}
