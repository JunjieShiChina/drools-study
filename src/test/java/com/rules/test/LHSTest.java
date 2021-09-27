package com.rules.test;

import com.rules.model.ListMapFact;
import com.rules.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LHSTest {

    @Test
    public void test() {
        KieSession kieSession = KieServices.get().getKieClasspathContainer().newKieSession("lhs-test-session");

        ListMapFact listMapFact = new ListMapFact();
        List<Person> personList = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            Person person = new Person();
            person.setAge(i);
            personList.add(person);
        }
        listMapFact.setPersonList(personList);

        Map<String, Integer> personListMap = new HashMap<>();
        personListMap.put("personList", 1);
        listMapFact.setPersonListMap(personListMap);

        kieSession.insert(listMapFact);

        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
