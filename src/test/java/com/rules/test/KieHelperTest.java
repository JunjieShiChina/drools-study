package com.rules.test;

import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

public class KieHelperTest {

    @Test
    public void test() {
        KieHelper kieHelper = new KieHelper();
        kieHelper.addResource(ResourceFactory.newClassPathResource("com/rules/kieHelper/kie-helper1.drl"), ResourceType.DRL);
        KieBase kieBase = kieHelper.build();
        KieSession kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("-----------------------------");

        kieHelper.addResource(ResourceFactory.newClassPathResource("com/rules/kieHelper/kie-helper2.drl"), ResourceType.DRL);
        kieBase = kieHelper.build();
        kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();
        kieSession.dispose();

        System.out.println("-------------------------------");
        kieHelper.addContent("package com.rules.kieHelper\n" +
                "\n" +
                "rule \"kieHelper-test3\"\n" +
                "when\n" +
                "then\n" +
                "    System.out.println(\"kieHelper-test3 executed\");\n" +
                "end", ResourceType.DRL);

        kieBase = kieHelper.build();
        kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
