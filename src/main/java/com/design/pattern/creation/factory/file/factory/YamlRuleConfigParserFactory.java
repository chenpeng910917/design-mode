package com.design.pattern.creation.factory.file.factory;

import com.design.pattern.creation.factory.file.parser.RuleConfigParser;
import com.design.pattern.creation.factory.file.parser.YamlRuleConfigParser;

/**
 * yaml解析器工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class YamlRuleConfigParserFactory implements RuleConfigParserFactory {

    @Override
    public RuleConfigParser createParser() {
        return new YamlRuleConfigParser();
    }
}
