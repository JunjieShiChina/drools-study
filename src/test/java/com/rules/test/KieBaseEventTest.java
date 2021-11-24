package com.rules.test;

import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.event.kiebase.BeforeKiePackageRemovedEvent;
import org.kie.api.event.kiebase.DefaultKieBaseEventListener;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

public class KieBaseEventTest {

    @Test
    public void test() {

        KieHelper kieHelper = new KieHelper();
        kieHelper.addResource(ResourceFactory.newClassPathResource("com/rules/kieHelper/kie-helper1.drl"), ResourceType.DRL);
        kieHelper.addResource(ResourceFactory.newClassPathResource("com/rules/kieHelper/kie-helper2.drl"), ResourceType.DRL);
        KieBase kieBase = kieHelper.build();

        kieBase.addEventListener(new DefaultKieBaseEventListener(){
            @Override
            public void beforeKiePackageRemoved(BeforeKiePackageRemovedEvent event) {
                super.beforeKiePackageRemoved(event);
                String kiePackageName = event.getKiePackage().getName();
                System.out.println(kiePackageName + " be removed!");
            }
        });
        kieBase.removeKiePackage("com.rules.kieHelper");

        KieSession kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();
        kieSession.dispose();

    }

}
