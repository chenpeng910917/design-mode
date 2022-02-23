package com.design.mode.factory.file.factory;

import com.design.mode.factory.file.parser.RuleConfigParser;
import com.design.mode.factory.file.parser.YamlRuleConfigParser;

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
