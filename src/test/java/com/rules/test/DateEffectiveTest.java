package com.rules.test;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DateEffectiveTest {

    @Test
    public void test() {
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");
        KieServices kieServices = KieServices.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession("dateEffective-test-Session");



        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
