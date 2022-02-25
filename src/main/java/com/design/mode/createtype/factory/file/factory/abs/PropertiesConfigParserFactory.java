package com.design.mode.createtype.factory.file.factory.abs;

import com.design.mode.createtype.factory.file.parser.PropertiesRuleConfigParser;
import com.design.mode.createtype.factory.file.parser.RuleConfigParser;
import com.design.mode.createtype.factory.file.parser.abs.PropertiesSystemConfigParser;
import com.design.mode.createtype.factory.file.parser.abs.SystemConfigParser;

/**
 * properties解析器工厂
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
