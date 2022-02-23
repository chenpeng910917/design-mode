package com.design.mode.factory.file.parser.abs;

import com.design.mode.factory.file.parser.RuleConfigParser;

/**
 * properties系统配置文件解析器
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class PropertiesSystemConfigParser implements SystemConfigParser {
    @Override
    public String parser() {
        return "已解析出系统配置properties数据";
    }
}
