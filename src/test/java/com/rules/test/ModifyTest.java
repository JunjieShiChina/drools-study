package com.rules.test;

import com.rules.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

public class ModifyTest {

    @Test
    public void test() {
        KieSession kieSession = KieServices.get().getKieClasspathContainer().newKieSession("modify-test-session");
        Person person = new Person();
        person.setAge(15);
        kieSession.insert(person);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
