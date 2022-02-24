package com.mashibing.servlet.impl;

import com.mashibing.request.MyRequest;
import com.mashibing.response.MyResponse;
import com.mashibing.servlet.MyServlet;
import lombok.Data;

import java.io.IOException;

@Data
public class MyServletImpl extends MyServlet {

    @Override
    public void doGet(MyRequest req, MyResponse resp) throws IOException {
        resp.write("doGet");
    }

    @Override
    public void doPost(MyRequest req, MyResponse resp) throws IOException {
        resp.write("doPost");
    }

    @Override
    public void service(MyRequest req, MyResponse resp) throws IOException {
        String method = req.getRequestMethod();
        switch (method){
            case METHOD_GET:
                doGet(req,resp);
                break;
            case METHOD_POST:
                doPost(req,resp);
                break;
        }
    }
}
