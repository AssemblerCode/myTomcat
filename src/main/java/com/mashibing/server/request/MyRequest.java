package com.mashibing.server.request;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

@Data
public class MyRequest implements Serializable {
    private String requestUrl;
    private String protocol;
    private String requestMethod;

    public MyRequest(InputStream is) throws IOException {
        String enter = "\n";
        byte buff[] = new byte[1024];//用来存放缓存的数组
        int len = 0;//每次读取的长度
        String str = "";//接收请求的变量
        while ((len = is.read(buff)) > 0) {//证明有数据读入
            str = new String(buff, 0, len);
        }
        String strArray[] = str.split(enter);//读取请求行
        String data = strArray[0];//格式为 GET / HTTP/1.1
        String dataArr[] = data.split(" ");
        String method = dataArr[0];
        String url = dataArr[1];
        String protocol = dataArr[2];

        this.setRequestMethod(requestMethod);
        this.setRequestUrl(requestUrl);
        this.setProtocol(protocol);

        is.close();
    }
}
