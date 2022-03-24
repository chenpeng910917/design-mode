package com.design.pattern.creation.factory.file.annotations;

import com.design.pattern.creation.factory.file.parser.FileFormatEnum;
import com.design.pattern.creation.factory.file.parser.RuleConfigParser;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ObjectUtils;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 工厂策略
 * 注解类 {@link ParserStrategyAnnotation}
 *
 * @author chenpeng
 */
@Slf4j
public class StrategyFactory {

    private static final Map<String, RuleConfigParser> STRATEGY_MAP = Maps.newHashMap();

    static {
        // 初始化策略
        // 启动项目时加载 只加载一次
        log.info("------------------初始化策略工厂------------------");
        // 指定扫描的包名返回存在ParserStrategyAnnotation注解的类集合
        List<Class<?>> list = scanClass("com.design.mode.factory.file.parser", ParserStrategyAnnotation.class);
        for (Class<?> clazz : list) {
            // 获取注解信息
            ParserStrategyAnnotation annotation = AnnotationUtils.findAnnotation(clazz, ParserStrategyAnnotation.class);
            RuleConfigParser ruleConfigParser = null;
            try {
                ruleConfigParser = (RuleConfigParser) clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            if (annotation == null) {
                continue;
            }
            FileFormatEnum fileFormatEnum = annotation.fileFormat();
            STRATEGY_MAP.put(fileFormatEnum.getSuffix(), ruleConfigParser);
        }
    }
//    /**
//     * 初始化策略
//     * 启动项目时加载 只加载一次
//     */
//    @PostConstruct
//    private static void initStrategy() throws InstantiationException, IllegalAccessException {
//
//        log.info("------------------初始化策略工厂------------------");
//        // 指定扫描的包名返回存在ParserStrategyAnnotation注解的类集合
//        List<Class<?>> list = scanClass("com.design.mode.factory.file.parser", ParserStrategyAnnotation.class);
//        for (Class<?> clazz : list) {
//            // 获取注解信息
//            ParserStrategyAnnotation annotation = AnnotationUtils.findAnnotation(clazz, ParserStrategyAnnotation.class);
//            RuleConfigParser ruleConfigParser = (RuleConfigParser) clazz.newInstance();
//            if (annotation == null) {
//                continue;
//            }
//            FileFormatEnum fileFormatEnum = annotation.fileFormat();
//            STRATEGY_MAP.put(fileFormatEnum.getSuffix(), ruleConfigParser);
//        }
//    }

    /**
     * 获取策略
     */
    public static RuleConfigParser getStrategy(String key) {
        return STRATEGY_MAP.get(key);
    }

    /**
     * 扫描包得到类中包含的注解的类
     *
     * @param classPath  包路径
     * @param annotation 注解
     * @return 包含的注解的类
     */
    public static List<Class<?>> scanClass(String classPath, Class<? extends Annotation> annotation) {
        List<Class<?>> classList = Lists.newArrayList();
        if (ObjectUtils.isEmpty(classPath)) {
            return classList;
        }
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false);
        TypeFilter includeFilter = (metadataReader, metadataReaderFactory) -> true;
        provider.addIncludeFilter(includeFilter);
        // 指定扫描的包名
        Set<BeanDefinition> candidateComponents = provider.findCandidateComponents(classPath);
        System.out.println(candidateComponents);
        Set<BeanDefinition> beanDefinitionSet = Sets.newHashSet();
        beanDefinitionSet.addAll(candidateComponents);

        beanDefinitionSet.forEach(beanDefinition -> {
            try {
                Class<?> clazz = Class.forName(beanDefinition.getBeanClassName());

                if (!ObjectUtils.isEmpty(annotation)) {
                    // clazz.isAnnotationPresent(ParserStrategyAnnotation.class);和AnnotationUtils.getAnnotation(clazz, annotation)一样
                    if (!ObjectUtils.isEmpty(AnnotationUtils.getAnnotation(clazz, annotation))) {
                        classList.add(clazz);
                    }
                } else {
                    classList.add(clazz);
                }
            } catch (ClassNotFoundException e) {
                log.error("类不存在", e);
            }
        });
        return classList;
    }
}
