package com.rules.test;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

public class TimerTest {
    @Test
    public void test() throws InterruptedException {
        KieSession kieSession = KieServices.get().getKieClasspathContainer().newKieSession("timerTest-test-Session");
        kieSession.fireAllRules();
        kieSession.fireUntilHalt();
        kieSession.dispose();


    }
}
