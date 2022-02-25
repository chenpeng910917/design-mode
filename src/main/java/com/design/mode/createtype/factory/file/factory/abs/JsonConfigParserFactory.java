package com.design.mode.createtype.factory.file.factory.abs;

import com.design.mode.createtype.factory.file.parser.JsonRuleConfigParser;
import com.design.mode.createtype.factory.file.parser.RuleConfigParser;
import com.design.mode.createtype.factory.file.parser.abs.JsonSystemConfigParser;
import com.design.mode.createtype.factory.file.parser.abs.SystemConfigParser;

/**
 * json系统配置解析器抽象工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class JsonConfigParserFactory implements ConfigParserFactory {

    @Override
    public RuleConfigParser createRuleParser() {
        return new JsonRuleConfigParser();
    }

    @Override
    public SystemConfigParser createSystemParser() {
        return new JsonSystemConfigParser();
    }
}
