package com.rules.test;

import com.rules.calendar1.WeekDayNotInclud3Calendar;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class CalendarTest {

    @Test
    public void test() {
        KieServices kieServices = KieServices.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("calendar-test-session");
        kieSession.getCalendars().set("weekDayNotInclud3", new WeekDayNotInclud3Calendar());
        kieSession.fireAllRules();
        kieSession.dispose();


    }
}
