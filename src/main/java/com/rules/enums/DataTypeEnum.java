package com.rules.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DataTypeEnum {
    STRING("java.lang.String", "字符串"),
    DOUBLE("java.lang.Double", "数字计算型"),
    INTEGER("java.lang.Integer", "数字型");
    private String value;
    private String desc;
}
