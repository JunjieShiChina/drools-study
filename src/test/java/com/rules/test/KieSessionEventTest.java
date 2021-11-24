package com.rules.test;

import com.rules.model.Person;
import org.drools.core.event.DefaultAgendaEventListener;
import org.drools.core.event.DefaultRuleRuntimeEventListener;
import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.event.kiebase.BeforeKiePackageRemovedEvent;
import org.kie.api.event.kiebase.DefaultKieBaseEventListener;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

public class KieSessionEventTest {

    @Test
    public void test() {

        KieHelper kieHelper = new KieHelper();
        kieHelper.addResource(ResourceFactory.newClassPathResource("com/rules/kieHelper/kie-helper1.drl"), ResourceType.DRL);
        kieHelper.addResource(ResourceFactory.newClassPathResource("com/rules/kieHelper/kie-helper2.drl"), ResourceType.DRL);
        KieBase kieBase = kieHelper.build();
        KieSession kieSession = kieBase.newKieSession();

        kieSession.addEventListener(new DefaultRuleRuntimeEventListener() {
            @Override
            public void objectInserted(ObjectInsertedEvent event) {
                super.objectInserted(event);
                String personName = ((Person) event.getObject()).getName();
                System.out.println(personName + " was inserted");
            }
        });
        kieSession.addEventListener(new DefaultAgendaEventListener(){
            @Override
            public void beforeMatchFired(BeforeMatchFiredEvent event) {
                super.beforeMatchFired(event);
                String name = event.getMatch().getRule().getName();
                System.out.println("rule " + name + " matched");
            }
        });
        kieSession.insert(new Person(2, "tom"));
        kieSession.fireAllRules();
        kieSession.dispose();

    }

}
