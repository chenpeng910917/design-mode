package com.design.mode.createtype.factory.file.factory.abs;

import com.design.mode.createtype.factory.file.parser.FileFormatEnum;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 文件解析器抽象工厂的工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class ConfigParserFactoryMap {

    private static final Map<String, ConfigParserFactory> CACHE_PARSERS = Maps.newHashMap();

    static {
        CACHE_PARSERS.put(FileFormatEnum.JSON.getSuffix(), new JsonConfigParserFactory());
        CACHE_PARSERS.put(FileFormatEnum.XML.getSuffix(), new XmlConfigParserFactory());
        CACHE_PARSERS.put(FileFormatEnum.YAML.getSuffix(), new YamlConfigParserFactory());
        CACHE_PARSERS.put(FileFormatEnum.PROPERTIES.getSuffix(), new PropertiesConfigParserFactory());
    }

    /**
     * 创建文件解析工厂
     *
     * @param fileFormat 文件格式
     * @return 解析器对象
     */
    public static ConfigParserFactory createParser(String fileFormat) {
        return CACHE_PARSERS.get(fileFormat);
    }
}
