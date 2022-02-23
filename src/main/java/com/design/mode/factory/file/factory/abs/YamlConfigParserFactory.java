package com.design.mode.factory.file.factory.abs;

import com.design.mode.factory.file.parser.RuleConfigParser;
import com.design.mode.factory.file.parser.YamlRuleConfigParser;
import com.design.mode.factory.file.parser.abs.PropertiesSystemConfigParser;
import com.design.mode.factory.file.parser.abs.SystemConfigParser;

/**
 * yaml解析器工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class YamlConfigParserFactory implements ConfigParserFactory {

    @Override
    public RuleConfigParser createRuleParser() {
        return new YamlRuleConfigParser();
    }

    @Override
    public SystemConfigParser createSystemParser() {
        return new PropertiesSystemConfigParser();
    }
}
