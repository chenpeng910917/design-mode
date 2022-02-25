package com.design.mode.createtype.factory.file.factory;

import com.design.mode.createtype.factory.file.parser.FileFormatEnum;
import com.design.mode.createtype.factory.file.parser.JsonRuleConfigParser;
import com.design.mode.createtype.factory.file.parser.PropertiesRuleConfigParser;
import com.design.mode.createtype.factory.file.parser.RuleConfigParser;
import com.design.mode.createtype.factory.file.parser.XmlRuleConfigParser;
import com.design.mode.createtype.factory.file.parser.YamlRuleConfigParser;

/**
 * 文件解析简单工厂
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class RuleConfigParserSimpleFactory {

    /**
     * 创建文件解析工厂
     *
     * @param fileFormat 文件格式
     * @return 解析器对象
     */
    public static RuleConfigParser createParser(String fileFormat) {
        RuleConfigParser parser = null;
        if (FileFormatEnum.JSON.getSuffix().equalsIgnoreCase(fileFormat)) {
            parser = new JsonRuleConfigParser();
        } else if (FileFormatEnum.XML.getSuffix().equalsIgnoreCase(fileFormat)) {
            parser = new XmlRuleConfigParser();
        } else if (FileFormatEnum.YAML.getSuffix().equalsIgnoreCase(fileFormat)) {
            parser = new YamlRuleConfigParser();
        } else if (FileFormatEnum.PROPERTIES.getSuffix().equalsIgnoreCase(fileFormat)) {
            parser = new PropertiesRuleConfigParser();
        }
        if (parser == null) {
            throw new RuntimeException("没有匹配到文件解析器");
        }
        return parser;
    }
}
