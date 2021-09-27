package com.rules.test;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

import java.io.InputStream;

public class DecisiontablesTest {

    @Test
    public void test() {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("decisiontables/dicisionTableTest1.xls");
        SpreadsheetCompiler spreadsheetCompiler = new SpreadsheetCompiler();
        String drl = spreadsheetCompiler.compile(resourceAsStream, InputType.XLS);
        System.out.println(drl);

        KieSession kieSession = KieServices.get().getKieClasspathContainer().newKieSession("dicisionTable-test-session");
        kieSession.fireAllRules();
        kieSession.dispose();
    }

}
