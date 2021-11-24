package com.rules.test;

import com.rules.model.Person;
import com.rules.service.ChannelService;
import com.rules.service.impl.ChannelServiceImpl;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class ChannelTest {

    @Test
    public void test() {
        KieServices kieServices = KieServices.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession("channel-test-session");

        ChannelService channelService = new ChannelServiceImpl();
        kieSession.registerChannel("channel-service", channelService);

        Person person = new Person();
        person.setName("123channel");
        person.setAge(123);
        kieSession.insert(person);

        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
