package com.blackfat.rule.engine.core.listener;

import lombok.extern.slf4j.Slf4j;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;

/**
 * @author wangfeiyang
 * @Description
 * @create 2019-12-09 11:32
 * @since 1.0-SNAPSHOT
 */
@Slf4j
public class TrackingAgendaEventListener extends DefaultAgendaEventListener {

    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        super.afterMatchFired(event);
        log.info("TrackingAgendaEventListener.afterMatchFired:{}",event.getMatch().getRule().getName());
    }
}
