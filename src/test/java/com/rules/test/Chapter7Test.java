package com.rules.test;

import com.rules.model.Car;
import com.rules.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class Chapter7Test {
    @Test
    public void test () {
        KieServices kieServices = KieServices.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("test-rules");
        kieSession.getAgenda().getAgendaGroup("car_discount_rule").setFocus();

        Car c1 = new Car();
        Person p1 = new Person();
        p1.setAge(30);
        c1.setPerson(p1);

        Car c2 = new Car();
        Person p2 = new Person();
        p2.setAge(70);
        c2.setPerson(p2);

        kieSession.insert(c1);
        FactHandle factHandle2 = kieSession.insert(c2);
        int execRuleCnt = kieSession.fireAllRules();
        System.out.println("总共" + execRuleCnt + "规则执行了");
        System.out.println("30 age car discount " + c1.getDiscount());
        System.out.println("70 age car discount " + c2.getDiscount());
        System.out.println("factHandle2: " + factHandle2.toExternalForm());

        System.out.println("---------------------------------------------");
        c2.getPerson().setAge(20);
        kieSession.update(factHandle2, c2);
        kieSession.getAgenda().getAgendaGroup("car_discount_rule").setFocus();
        execRuleCnt = kieSession.fireAllRules();
        System.out.println("总共" + execRuleCnt + "规则执行了");
        System.out.println("30 age car discount " + c1.getDiscount());
        System.out.println("20 age car discount " + c2.getDiscount());
        System.out.println("factHandle2: " + factHandle2.toExternalForm());

        kieSession.dispose();
    }
}
