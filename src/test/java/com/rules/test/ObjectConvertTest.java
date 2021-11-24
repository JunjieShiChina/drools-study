package com.rules.test;

import com.rules.enums.DataTypeEnum;
import com.rules.model.ObjectDef;
import com.rules.model.ObjectPropertyDef;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ObjectConvertTest {

    @Test
    public void test() {
        ObjectDef objectDef = new ObjectDef();
        objectDef.setId(1L);
        objectDef.setCode("Person");

        List<ObjectPropertyDef> objectPropertyDefList = new ArrayList<>();
        ObjectPropertyDef objectPropertyDef1 = new ObjectPropertyDef();
        objectPropertyDef1.setObjectDefId(1L);
        objectPropertyDef1.setCode("name");
        objectPropertyDef1.setDataType(DataTypeEnum.STRING.getValue());
        objectPropertyDefList.add(objectPropertyDef1);

        ObjectPropertyDef objectPropertyDef2 = new ObjectPropertyDef();
        objectPropertyDef2.setObjectDefId(1L);
        objectPropertyDef2.setCode("age");
        objectPropertyDef2.setDataType(DataTypeEnum.INTEGER.getValue());
        objectPropertyDefList.add(objectPropertyDef2);


        StringBuilder factBuilder = new StringBuilder();
        factBuilder.append("declare ");
        factBuilder.append(objectDef.getCode());
        factBuilder.append("\n");
        objectPropertyDefList.stream().forEach(objectPropertyDef -> factBuilder.append("    ").append(objectPropertyDef.getCode())
        .append(" : ").append(objectPropertyDef.getDataType()).append("\n"));
        factBuilder.append("end");
        System.out.println(factBuilder);

        

    }

}
