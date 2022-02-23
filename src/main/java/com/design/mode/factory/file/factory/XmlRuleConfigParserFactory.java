package com.design.mode.factory.file.factory;

import com.design.mode.factory.file.parser.RuleConfigParser;
import com.design.mode.factory.file.parser.XmlRuleConfigParser;

/**
 * xml解析器工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class XmlRuleConfigParserFactory implements RuleConfigParserFactory {

    @Override
    public RuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
