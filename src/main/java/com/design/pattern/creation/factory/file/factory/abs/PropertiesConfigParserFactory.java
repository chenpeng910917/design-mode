package com.design.pattern.creation.factory.file.factory.abs;

import com.design.pattern.creation.factory.file.parser.PropertiesRuleConfigParser;
import com.design.pattern.creation.factory.file.parser.RuleConfigParser;
import com.design.pattern.creation.factory.file.parser.abs.PropertiesSystemConfigParser;
import com.design.pattern.creation.factory.file.parser.abs.SystemConfigParser;

/**
 * properties系统配置解析器抽象工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class PropertiesConfigParserFactory implements ConfigParserFactory {

    @Override
    public RuleConfigParser createRuleParser() {
        return new PropertiesRuleConfigParser();
    }

    @Override
    public SystemConfigParser createSystemParser() {
        return new PropertiesSystemConfigParser();
    }
}
