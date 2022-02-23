package com.design.mode.factory.file.parser;

/**
 * yaml文件解析器
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class YamlRuleConfigParser implements RuleConfigParser {
    @Override
    public String parser() {
        return "已解析出yaml数据";
    }
}
