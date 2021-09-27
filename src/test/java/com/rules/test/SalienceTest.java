package com.rules.test;

import com.rules.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

public class SalienceTest {

    @Test
    public void test() {
        KieSession kieSession = KieServices.get().getKieClasspathContainer().newKieSession("salience-test-session");

        Person person = new Person();
        person.setAge(8);
        kieSession.insert(person);

        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
