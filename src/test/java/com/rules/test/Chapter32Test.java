package com.rules.test;

import com.rules.model.Car;
import com.rules.model.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Chapter32Test {

    @Test
    public void test() {
        KieServices kieServices = KieServices.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("chapter32-test-session");

        Person person = new Person();
        person.setAge(20);
        kieSession.insert(person);

        Car car = new Car();
        car.setDiscount(70);
        kieSession.insert(car);

        kieSession.fireAllRules();

        kieSession.dispose();
    }

}
