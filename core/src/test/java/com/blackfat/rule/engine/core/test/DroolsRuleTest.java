package com.blackfat.rule.engine.core.test;


import com.blackfat.rule.engine.core.entity.Event;
import com.blackfat.rule.engine.core.listener.TrackingAgendaEventListener;
import com.blackfat.rule.engine.core.util.DroolsRuleBuilder;
import com.blackfat.rule.engine.core.util.DroolsRuleContentBuilder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

/**
 * @author wangfeiyang
 * @Description
 * @create 2019-12-09 11:01
 * @since 1.0-SNAPSHOT
 */

public class DroolsRuleTest {


    public static final String rule = "rule \"wangfeiyangR3\"\n" +
            "    no-loop true\n" +
            "    when\n" +
            "        $e: Event(1==1);\n" +
            "    then\n" +
            "end";



    @Before
    public void init(){

    }

    @Test
    public void ruleTest(){
        KieContainer kieContainer = DroolsRuleBuilder.loadRule("1",
                DroolsRuleContentBuilder.generateRuleContent(Lists.newArrayList(rule)));
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession();
        TrackingAgendaEventListener trackingAgendaEventListener = new TrackingAgendaEventListener();
        kieSession.addEventListener(trackingAgendaEventListener);
        Event event = new Event();
        event.setPayload(Maps.newHashMap());
        kieSession.execute(event);
    }
}
