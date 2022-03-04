package com.design.mode.creation.factory.file.factory;

import com.design.mode.creation.factory.file.parser.PropertiesRuleConfigParser;
import com.design.mode.creation.factory.file.parser.RuleConfigParser;

/**
 * properties解析器工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class PropertiesRuleConfigParserFactory implements RuleConfigParserFactory {

    @Override
    public RuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
