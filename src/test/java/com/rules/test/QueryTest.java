package com.rules.test;

import com.rules.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

public class QueryTest {

    @Test
    public void test() {
        KieSession kieSession = KieServices.get().getKieClasspathContainer().newKieSession("query-test-session");

        Person person1 = new Person();
        person1.setAge(21);
        person1.setName("jerry");

        Person person2 = new Person();
        person2.setAge(19);
        person2.setName("tom");
        kieSession.insert(person1);
        kieSession.insert(person2);

        QueryResults queryResults = kieSession.getQueryResults("person-query-by-age", 18);
        System.out.println(queryResults.getIdentifiers());
        queryResults.forEach(queryResultsRow -> {
            Person person = (Person) queryResultsRow.get("$p");
            System.out.println(person.getName());
        });

        kieSession.fireAllRules();

        kieSession.dispose();
    }

}
