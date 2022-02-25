package com.design.mode.createtype.factory.file.factory;

import com.design.mode.createtype.factory.file.parser.FileFormatEnum;
import com.design.mode.createtype.factory.file.parser.JsonRuleConfigParser;
import com.design.mode.createtype.factory.file.parser.PropertiesRuleConfigParser;
import com.design.mode.createtype.factory.file.parser.RuleConfigParser;
import com.design.mode.createtype.factory.file.parser.XmlRuleConfigParser;
import com.design.mode.createtype.factory.file.parser.YamlRuleConfigParser;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 文件解析简单工厂2
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class RuleConfigParserSimple2Factory {

    private static final Map<String, RuleConfigParser> CACHE_PARSERS = Maps.newHashMap();

    static {
        CACHE_PARSERS.put(FileFormatEnum.JSON.getSuffix(), new JsonRuleConfigParser());
        CACHE_PARSERS.put(FileFormatEnum.XML.getSuffix(), new XmlRuleConfigParser());
        CACHE_PARSERS.put(FileFormatEnum.YAML.getSuffix(), new YamlRuleConfigParser());
        CACHE_PARSERS.put(FileFormatEnum.PROPERTIES.getSuffix(), new PropertiesRuleConfigParser());
    }

    /**
     * 创建文件解析工厂
     *
     * @param fileFormat 文件格式
     * @return 解析器对象
     */
    public static RuleConfigParser createParser(String fileFormat) {
        return CACHE_PARSERS.get(fileFormat);
    }
}
