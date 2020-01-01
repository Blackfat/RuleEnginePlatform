package com.blackfat.rule.engine.core.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author wangfeiyang
 * @Description
 * @create 2019-12-09 10:33
 * @since 1.0-SNAPSHOT
 */
@Data
public class Event {

    /**
     * 事件编号
     */
    private String eventCode;

    /**
     * 事件主体属性存储
     */
    private Map<String, Object> payload;


    /**
     * 事件序列号，唯一标识一个事件
     */
    private String seqNo;


}
