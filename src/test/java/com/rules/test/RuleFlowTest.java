package com.rules.test;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.RuleFlowGroup;

public class RuleFlowTest {

    @Test
    public void test() {
        KieSession kieSession = KieServices.get().getKieClasspathContainer().newKieSession("rule-flow-test-session");
        RuleFlowGroup ruleFlowGroup = kieSession.getAgenda().getRuleFlowGroup("flow-rule-group1");
        System.out.println(ruleFlowGroup.getName());
        ruleFlowGroup.clear();
        kieSession.getAgenda().getAgendaGroup("flow-rule-group1").setFocus();
        kieSession.getAgenda().getAgendaGroup("flow-rule-group2").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
