package com.blackfat.rule.engine.core.util;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author wangfeiyang
 * @Description
 * @create 2019-12-09 11:22
 * @since 1.0-SNAPSHOT
 */
public class DroolsRuleContentBuilder {

    private static final String DEFAULT_RULE_PACKAGE = "com.blackfat.rule";

    private static final String DEFAULT_EVENT_CLASS = "com.blackfat.rule.engine.core.entity.Event";


    public static String generateRuleContent(List<String> ruleList){
        if (CollectionUtils.isEmpty(ruleList)) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("package ");
        sb.append(DEFAULT_RULE_PACKAGE);
        sb.append(";\n");
        sb.append("import ");
        sb.append(DEFAULT_EVENT_CLASS);
        sb.append(";\n");

        ruleList.stream().forEach(rule ->{
            sb.append(rule);
            sb.append('\n');
        });

        return sb.toString();
    }
}
