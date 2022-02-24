package com.mashibing.response;

import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

@Data
public class MyResponse implements Serializable {
    private OutputStream os;

     public void write(String str) throws IOException {
        StringBuilder builder = new StringBuilder();
        builder= builder.append("HTTP/1.1 200 OK\n").append("Content-Type:text/html\n").append("\r\n").append("<html>" +
                "<body>" +
                "<h1>" +
                str +
                "</h1>" +
                "</body>" +
                "</html>");
        this.os.write(builder.toString().getBytes());
        os.flush();
//        os.close();

    }

    public MyResponse(OutputStream os) {
        this.os = os;
    }
}
