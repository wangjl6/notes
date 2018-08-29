package com.study.gupao.client;

import com.study.gupao.dto.RequestBody;
import com.study.gupao.dto.ResponseBody;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

/**
 * 快！写点注释
 *
 * @author BigWang
 * @since 2018/7/1
 **/
public class Client {

    public static ResponseBody connectionServer(RequestBody requestBody) throws IOException {
        Socket socket = new Socket("127.0.0.1",9999);
        System.out.println("===========客户端发送远程访问==========="+requestBody);
        InputStream inputStream = null;
        ObjectInputStream objectInputStream =null;

        OutputStream outputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(requestBody);
            objectOutputStream.flush();
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            ResponseBody responseBody=(ResponseBody) objectInputStream.readObject();
            return responseBody;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                inputStream.close();
            }
            if(objectInputStream!=null){
                objectInputStream.close();
            }
            if(outputStream!=null){
                outputStream.close();
            }
            if(byteArrayOutputStream!=null){
                byteArrayOutputStream.close();
            }

        }
        return null;
    }
}
