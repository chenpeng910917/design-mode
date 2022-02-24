package com.design.mode.factory.file.factory;

import com.design.mode.factory.file.annotations.ParserStrategyAnnotation;
import com.design.mode.factory.file.parser.FileFormatEnum;
import com.design.mode.factory.file.parser.JsonRuleConfigParser;
import com.design.mode.factory.file.parser.RuleConfigParser;

/**
 * json解析器工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class JsonRuleConfigParserFactory implements RuleConfigParserFactory {

    @Override
    public RuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
