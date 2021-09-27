package com.rules.test;

import com.rules.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

public class EnumTest {

    @Test
    public void test() {
        KieSession kieSession = KieServices.get().getKieClasspathContainer().newKieSession("enum-test-session");
        Person person = new Person();
        person.setAge(0);
        kieSession.insert(person);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
