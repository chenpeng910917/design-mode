package com.design.mode.creation.factory.file.parser.abs;

/**
 * yaml系统配置文件解析器
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class YamlSystemConfigParser implements SystemConfigParser {
    @Override
    public String parser() {
        return "已解析出系统配置yaml数据";
    }
}
