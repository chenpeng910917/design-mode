package com.design.mode.createtype.factory.file.parser.abs;

/**
 * json系统配置文件解析器
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class JsonSystemConfigParser implements SystemConfigParser {
    @Override
    public String parser() {
        return "已解析出系统配置json数据";
    }
}
