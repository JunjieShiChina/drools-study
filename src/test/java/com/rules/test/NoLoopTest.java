package com.rules.test;

import com.rules.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class NoLoopTest {

    @Test
    public void testNoLoop() {
        KieServices kieServices = KieServices.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieClasspathContainer.newKieSession("noloop-test-session");

        Person person = new Person();
        person.setAge(35);
        kieSession.insert(person);

        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
