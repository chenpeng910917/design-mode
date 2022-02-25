package com.design.mode.createtype.factory.file.factory.abs;

import com.design.mode.createtype.factory.file.parser.RuleConfigParser;
import com.design.mode.createtype.factory.file.parser.XmlRuleConfigParser;
import com.design.mode.createtype.factory.file.parser.abs.SystemConfigParser;
import com.design.mode.createtype.factory.file.parser.abs.XmlSystemConfigParser;

/**
 * xml解析器工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class XmlConfigParserFactory implements ConfigParserFactory {

    @Override
    public RuleConfigParser createRuleParser() {
        return new XmlRuleConfigParser();
    }

    @Override
    public SystemConfigParser createSystemParser() {
        return new XmlSystemConfigParser();
    }
}
