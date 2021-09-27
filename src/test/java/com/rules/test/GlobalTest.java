package com.rules.test;

import com.rules.service.TestService;
import com.rules.service.impl.TestServiceImpl;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

public class GlobalTest {

    @Test
    public void test() {
        KieSession kieSession = KieServices.get().getKieClasspathContainer().newKieSession("global-test-session");

        TestService testService = new TestServiceImpl();
        kieSession.setGlobal("testService2", testService);

        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
