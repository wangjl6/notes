package com.study.gupao.server;

import com.study.gupao.dto.RequestBody;
import com.study.gupao.dto.ResponseBody;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * 快！写点注释
 *
 * @author BigWang
 * @since 2018/7/1
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        registerServer(9999);
    }

    public static void registerServer(Integer port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        InputStream inputStream = null;
        ObjectInputStream objectInputStream =null;
        System.out.println("=========服务端接收消息=========");
        OutputStream outputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
                Socket socket = serverSocket.accept();
                objectInputStream = new ObjectInputStream(socket.getInputStream());
                RequestBody requestBody=(RequestBody) objectInputStream.readObject();
                Object data = DispatchServer.dispatch
                        (requestBody.getClazz(),requestBody.getMethod(),requestBody.getArgs());
                ResponseBody responseBody = new ResponseBody();
                responseBody.setCode("1");
                responseBody.setMessage("获取数据成功");
                responseBody.setData(data);

                outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(responseBody);
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
    }
}
