package com.rules.test;

import com.rules.model.Car;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StatelessKieSessionTest {

    @Test
    public void testStatelessKieSession() {
        KieServices kieServices = KieServices.get();
        KieContainer kieClasspathContainer = kieServices.getKieClasspathContainer();
        StatelessKieSession statelessKieSession = kieClasspathContainer.newStatelessKieSession("noloop-test-session");
        Random random = new Random();
        List<Car> carList = new ArrayList<>();
        for(int i = 0; i < 10; i ++) {
            Car car = new Car();
            car.setDiscount(random.nextInt(100));
            carList.add(car);
        }
        statelessKieSession.execute(carList);
    }

}
