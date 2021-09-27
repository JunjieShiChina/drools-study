package com.rules.test;

import com.alibaba.fastjson.JSON;
import com.rules.model.Cat;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;

public class DeclareTest {

    @Test
    public void test() {
        KieSession kieSession = KieServices.get().getKieClasspathContainer().newKieSession("declare-test-session");
        kieSession.fireAllRules();
        QueryResults queryResults = kieSession.getQueryResults("cat-q");
        queryResults.forEach(queryResultsRow -> {
            Object catObj = queryResultsRow.get("$c");
            Cat cat = JSON.parseObject(JSON.toJSONString(catObj), Cat.class);
            System.out.println(cat);
        });
        kieSession.dispose();
    }

}
