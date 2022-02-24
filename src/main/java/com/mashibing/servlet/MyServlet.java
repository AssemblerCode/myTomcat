package com.mashibing.servlet;

import com.mashibing.request.MyRequest;
import com.mashibing.response.MyResponse;
import lombok.Data;

import java.io.IOException;
import java.io.Serializable;

@Data
public  abstract class MyServlet implements Serializable {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";

    public abstract void doGet(MyRequest req, MyResponse resp) throws IOException;
    public abstract void doPost(MyRequest req, MyResponse resp) throws IOException;

    public void service(MyRequest req,MyResponse resp) throws IOException {
//        String method = req.getRequestMethod();
//        switch (method){
//            case METHOD_GET:
//
//                break;
//            case METHOD_POST:
//
//                break;
//        }
    }
}
