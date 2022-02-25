package com.design.mode.createtype.factory.file;

import com.design.mode.createtype.factory.file.annotations.StrategyFactory;
import com.design.mode.createtype.factory.file.factory.RuleConfigParserFactory;
import com.design.mode.createtype.factory.file.factory.RuleConfigParserFactoryMap;
import com.design.mode.createtype.factory.file.factory.RuleConfigParserSimple2Factory;
import com.design.mode.createtype.factory.file.factory.RuleConfigParserSimpleFactory;
import com.design.mode.createtype.factory.file.factory.abs.ConfigParserFactory;
import com.design.mode.createtype.factory.file.factory.abs.ConfigParserFactoryMap;
import com.design.mode.createtype.factory.file.parser.FileFormatEnum;
import com.design.mode.createtype.factory.file.parser.JsonRuleConfigParser;
import com.design.mode.createtype.factory.file.parser.PropertiesRuleConfigParser;
import com.design.mode.createtype.factory.file.parser.RuleConfigParser;
import com.design.mode.createtype.factory.file.parser.XmlRuleConfigParser;
import com.design.mode.createtype.factory.file.parser.YamlRuleConfigParser;
import com.design.mode.createtype.factory.file.parser.abs.SystemConfigParser;

/**
 * 文件格式匹配工厂例子
 *
 * @author chenpeng
 * @date 2022/2/23
 */
public class FileFactoryDemo {
    public static void main(String[] args) {
        // 不使用工厂模式
        ordinary();

        // 简单工厂
        simple();

        // 简单工厂 第二种实现
        simple2();

        // 工厂方法
        factory();

        // 抽象工厂
        absFactory();

        // 利用自定义注解+反射创建策略工厂 todo 算是DI吗
        strategyFactory();

        // spring BeanFactory bean工厂  DI依赖注入
    }

    /**
     * 不使用工厂模式
     * 缺点：需要自己创建大量对象
     */
    private static void ordinary() {
        String fileFormat = FileFormatEnum.JSON.getSuffix();
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
        String parserData = parser.parser();
        System.out.println(parserData);
    }

    /**
     * 简单工厂
     * 把创建对象交给单独类处理
     * 缺点：不符合开闭原则；创建对象if判断逻辑多(如果没几个if尽量使用简单工厂)
     * 优点：可读性好
     */
    private static void simple() {
        String fileFormat = FileFormatEnum.JSON.getSuffix();
        RuleConfigParser parser = RuleConfigParserSimpleFactory.createParser(fileFormat);
        String parserData = parser.parser();
        System.out.println(parserData);
    }

    /**
     * 简单工厂2
     * 使用Map方式去掉多if 类似单例+工厂
     * 优点：去掉了if判断
     * 缺点：不符合开闭原则
     */
    private static void simple2() {
        String fileFormat = FileFormatEnum.JSON.getSuffix();
        RuleConfigParser parser = RuleConfigParserSimple2Factory.createParser(fileFormat);
        String parserData = parser.parser();
        System.out.println(parserData);
    }

    /**
     * 工厂方法
     * 工厂方法模式比起简单工厂模式更加符合开闭原则。
     * 利用java多态实现
     * 缺点：可读性不好，如果商品过多类就会变多
     * 优点：去掉了if判断
     */
    private static void factory() {
        String fileFormat = FileFormatEnum.JSON.getSuffix();
        // 使用工厂的工厂解决if问题
        RuleConfigParserFactory parser = RuleConfigParserFactoryMap.createParser(fileFormat);
        RuleConfigParser parser1 = parser.createParser();
        String parserData = parser1.parser();
        System.out.println(parserData);
    }

    /**
     * 抽象工厂
     *
     * 什么时候用抽象工厂
     * 针对规则配置的解析器：基于接口IRuleConfigParser JsonRuleConfigParser XmlRuleConfigParser YamlRuleConfigParser PropertiesRuleConfigParser
     * 针对系统配置的解析器：基于接口ISystemConfigParser JsonSystemConfigParser XmlSystemConfigParser YamlSystemConfigParser PropertiesSystemConfigParser
     */
    private static void absFactory() {
        String fileFormat = FileFormatEnum.JSON.getSuffix();
        ConfigParserFactory parser = ConfigParserFactoryMap.createParser(fileFormat);
        // 文件格式匹配
        RuleConfigParser ruleParser = parser.createRuleParser();
        String ruleParserData = ruleParser.parser();
        System.out.println(ruleParserData);
        // 系统文件格式匹配
        SystemConfigParser systemParser = parser.createSystemParser();
        String systemParserData = systemParser.parser();
        System.out.println(systemParserData);
    }

    /**
     * 利用自定义注解+反射创建策略工厂
     */
    private static void strategyFactory() {
        RuleConfigParser strategy = StrategyFactory.getStrategy(FileFormatEnum.JSON.getSuffix());
        String ruleParserData = strategy.parser();
        System.out.println(ruleParserData);
        RuleConfigParser strategyXml = StrategyFactory.getStrategy(FileFormatEnum.XML.getSuffix());
        String ruleParserDataXml = strategyXml.parser();
        System.out.println(ruleParserDataXml);
    }
}
