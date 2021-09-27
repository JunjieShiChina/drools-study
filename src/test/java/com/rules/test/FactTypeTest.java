package com.rules.test;

import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class FactTypeTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        KieContainer kieClasspathContainer = KieServices.get().getKieClasspathContainer();
        KieBase kieBase = kieClasspathContainer.getKieBase("facttype-base");
        KieSession kieSession = kieBase.newKieSession();
        FactType dogFactType = kieBase.getFactType("com.rules.factTypeTest", "Dog");
        Object dog = dogFactType.newInstance();
        dogFactType.set(dog, "age", 3);
        kieSession.insert(dog);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
