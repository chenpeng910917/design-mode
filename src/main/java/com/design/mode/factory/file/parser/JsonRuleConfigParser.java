package com.design.mode.factory.file.parser;

/**
 * json文件解析器
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class JsonRuleConfigParser implements RuleConfigParser {
    @Override
    public String parser() {
        return "已解析出json数据";
    }
}
