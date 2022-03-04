package com.design.mode.creation.factory.file.parser;

import com.design.mode.creation.factory.file.annotations.ParserStrategyAnnotation;

/**
 * XML文件解析器
 *
 * @author chenpeng
 * @date 2022/2/23
 */
@ParserStrategyAnnotation(fileFormat = FileFormatEnum.XML)
public class XmlRuleConfigParser implements RuleConfigParser {
    @Override
    public String parser() {
        return "已解析出xml数据";
    }
}
