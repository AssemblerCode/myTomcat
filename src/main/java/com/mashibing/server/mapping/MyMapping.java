package com.mashibing.server.mapping;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class MyMapping implements Serializable {
    public static   Map<String, String> mapping = new HashMap();

    public static Map<String, String> getMapping(){
        return mapping;
    }

    static {
        //此处应该读取web.xml里面的<servlet>和<server-mapping>
        mapping.put("myServer", "com.mashibing.servlet.MyServlet");//请求路径和全限定名
    }
}
