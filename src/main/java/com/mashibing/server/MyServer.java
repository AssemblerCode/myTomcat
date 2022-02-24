package com.mashibing.server;

import com.mashibing.mapping.MyMapping;
import com.mashibing.request.MyRequest;
import com.mashibing.response.MyResponse;
import com.mashibing.servlet.impl.MyServletImpl;
import com.sun.xml.internal.ws.util.StringUtils;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

@Data
public class MyServer implements Serializable {
    public static void startServer(int port) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        ServerSocket ss = new ServerSocket(port);
        Socket accept = null;
        while (true) {
            accept = ss.accept();
            InputStream is = accept.getInputStream();
            OutputStream os = accept.getOutputStream();

            MyRequest request = new MyRequest(is);
            MyResponse response = new MyResponse(os);
            String classToStr=MyMapping.getMapping().get(request.getRequestUrl());
            if(classToStr!=null&&!"".equals(classToStr)){
                Class<MyServletImpl> cls = (Class<MyServletImpl>) Class.forName(classToStr);
                MyServletImpl myServlet = cls.newInstance();
                myServlet.service(request,response);
            }

            os.close();
            is.close();
            accept.close();
        }
//        ss.close();
    }

    public static void main(String[] args) {
        try {
            startServer(8080);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
