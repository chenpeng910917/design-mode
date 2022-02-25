package com.design.mode.createtype.factory.file.factory;

import com.design.mode.createtype.factory.file.parser.FileFormatEnum;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 文件解析器工厂的工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class RuleConfigParserFactoryMap {

    private static final Map<String, RuleConfigParserFactory> CACHE_PARSERS = Maps.newHashMap();

    static {
        CACHE_PARSERS.put(FileFormatEnum.JSON.getSuffix(), new JsonRuleConfigParserFactory());
        CACHE_PARSERS.put(FileFormatEnum.XML.getSuffix(), new XmlRuleConfigParserFactory());
        CACHE_PARSERS.put(FileFormatEnum.YAML.getSuffix(), new YamlRuleConfigParserFactory());
        CACHE_PARSERS.put(FileFormatEnum.PROPERTIES.getSuffix(), new PropertiesRuleConfigParserFactory());
    }

    /**
     * 创建文件解析工厂
     *
     * @param fileFormat 文件格式
     * @return 解析器对象
     */
    public static RuleConfigParserFactory createParser(String fileFormat) {
        return CACHE_PARSERS.get(fileFormat);
    }
}
