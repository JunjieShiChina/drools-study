package com.rules.test;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

public class FunctionTest {

    @Test
    public void test() {
        KieSession kieSession = KieServices.get().getKieClasspathContainer().newKieSession("function-test-session");
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
