package com.rules.model;

import lombok.Data;

@Data
public class LHSDTO {
    // 对象名称
    private String ObjectDefCode;
    // 属性名称
    private String propertyDefCode;
    // 符号名称
    private String symbolName;
    // 返回命名名称
    private String dataValueName;
}
