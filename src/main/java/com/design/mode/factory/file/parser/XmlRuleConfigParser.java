package com.design.mode.factory.file.parser;

/**
 * XML文件解析器
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class XmlRuleConfigParser implements RuleConfigParser {
    @Override
    public String parser() {
        return "已解析出xml数据";
    }
}
