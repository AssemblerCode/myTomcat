package com.mashibing.server.response;

import lombok.Data;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

@Data
public class MyResponse implements Serializable {
    private OutputStream os;

    public MyResponse(OutputStream os) {
        this.os = os;
    }

    public void write(String s) throws IOException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("HTTP/1.1 200 OK").append("\nContent-Type:text/html").append("\r\n").append("<html>").append("<head>" +
                "<title>" +
                "jinwh" +
                "</title>" +
                "</head>" +
                "<body>" +
                "<h1>" +
                s +
                "</h1>" +
                "</body>").append("</html>");//添加响应的文本
        byte bytes[] = buffer.toString().getBytes(StandardCharsets.UTF_8);//将响应文本变为byte数组返回
        os.write(bytes);
        os.flush();
        os.close();
    }
}
