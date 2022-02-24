package com.mashibing.request;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

@Data
public class MyRequest implements Serializable {
    private String requestMethod;//请求的方式
    private String requestUrl;//请求的url

    public MyRequest() {
    }

    public MyRequest(InputStream is) throws IOException {
        byte buffer[] = new byte[1024];//设置缓冲区域
        int len ;//每次读取的数据的长度
        String str=null;
        if((len=is.read(buffer))>0){
            str = new String(buffer,0,len);
        }
        String data=str.split("\n")[0];
        String params[]=data.split(" ");
        this.requestMethod = params[0];
        this.requestUrl = params[1];
//        if (is != null)
//            is.close();
    }
}
