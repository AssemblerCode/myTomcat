package com.mashibing.mapping;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class MyMapping implements Serializable {
    public static Map<String, String> mapping = new HashMap();

    public static Map<String, String> getMapping() {
        return mapping;
    }

    static {
        mapping.put("/myTomcat", "com.mashibing.servlet.impl.MyServletImpl");
    }
}
