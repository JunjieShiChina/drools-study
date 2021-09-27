package com.rules.test;

import com.rules.model.Car;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

public class MetaTest {

    @Test
    public void test() {
        KieSession kieSession = KieServices.get().getKieClasspathContainer().newKieSession("meta-test-session");
        Car car = new Car();
        car.setDiscount(60);
        kieSession.insert(car);
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
